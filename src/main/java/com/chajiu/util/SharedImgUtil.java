package com.chajiu.util;

import com.chajiu.pojo.Poetry;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.*;
import java.util.List;

public class SharedImgUtil {

    public static String makeImg(Poetry poetry, String url,String classpath) throws Exception {

        File file=new File(classpath+"static/photo/shareImg.png");

        BufferedImage image = ImageIO.read(file);
        Graphics2D graphics = image.createGraphics();

        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
        graphics.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

        //生成并绘制二维码
        ByteArrayOutputStream pngOutputStream = new ByteArrayOutputStream();
        createQR(url, pngOutputStream);
        BufferedImage qr = ImageIO.read(new ByteArrayInputStream(pngOutputStream.toByteArray()));
        graphics.drawImage(qr, 1498, 880, 175, 175, null);

        //获取诗内容
        String title = poetry.getTitle();
        String subtitle="【作者】"+poetry.getAuthor()+"【朝代】"+(poetry.getDynasty()=="T"?"唐":"宋");
        String[] split = poetry.getContent().split("\\|");
        List<String> contents=new ArrayList<>(Arrays.asList(split));

        //绘制诗
        FontRenderContext context = graphics.getFontRenderContext();
        graphics.setPaint(Color.black);

        //title
        Font font=new Font("楷体",Font.BOLD,58);
        graphics.setFont(font);

        Rectangle2D bounds = font.getStringBounds(title, context);  //计算title左上角坐标
        double x = (1193 - bounds.getWidth()) / 2;
        double y = 447;
        graphics.drawString(title,(int)x,(int)y);

        //subtitle
        font=new Font("宋体",Font.PLAIN,30);
        graphics.setFont(font);
        graphics.setPaint(Color.gray);

        bounds = font.getStringBounds(subtitle, context);  //计算左上角坐标
        x = (1193 - bounds.getWidth()) / 2;
        y += 48;
        graphics.drawString(subtitle,(int)x,(int)y);

        //添加间隔
        y+=10;

        //contents
        font=new Font("楷体",Font.PLAIN,38);
        graphics.setFont(font);
        graphics.setPaint(Color.black);

        for(String line:contents){
            bounds = font.getStringBounds(line, context);  //计算左上角坐标
            x = (1193 - bounds.getWidth()) / 2;
            y += 54;
            graphics.drawString(line,(int)x,(int)y);
        }

        //date
        font=new Font("楷体",Font.PLAIN,38);
        graphics.setFont(font);

        String date=DateUtil.todayInChinese();
        x = 740;
        y += 70;
        graphics.drawString(date,(int)x,(int)y);


        //保存图片
        Random rand=new Random();
        String imgName=rand.nextInt(999999)+".png"; //文件名
        File path = new File(classpath+"static/photo/sharedImg/"+imgName); //文件路径
        path.getParentFile().mkdirs();
        ImageIO.write(image,"PNG",path);    //写入img

        return imgName;

    }

    //生成二维码
    public static void createQR(String codeContent, OutputStream out) throws Exception {
        //二维码参数
        Map<EncodeHintType, Object> hints = new HashMap<>();
        hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");//设置字符编码类型
        //生成二维码，写入输出流
        BitMatrix bitMatrix = new MultiFormatWriter().encode(codeContent, BarcodeFormat.QR_CODE, 150, 150, hints);
        MatrixToImageWriter.writeToStream(bitMatrix, "PNG", out);
    }

}
