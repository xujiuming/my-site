package com.ming.core.utils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Random;

public class GeneratorCaptchaUtils {
    private static final int WIDTH = 150;
    private static final int HEIGHT = 50;
    private static final int NUM_CHARS = 5;
    private static final int INTER_CHAR_SPACE = 10;
    private static final int LINE_COUNT = 5;
    private static final int NOISE_COUNT = 100;
    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    private static final Random RANDOM = new Random();

    public static byte[] generateCaptcha(String captchaText) throws IOException {
        BufferedImage captchaImage = generateCaptchaImage(captchaText);
        return convertImageToByteArray(captchaImage, "png");
    }


    private static BufferedImage generateCaptchaImage(String text) {
        BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = image.createGraphics();

        // Antialiasing
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

        // 设置背景色
        g2d.setColor(new Color(255, 255, 255));
        g2d.fillRect(0, 0, WIDTH, HEIGHT);

        // 设置字体和颜色
        Font font = new Font("Arial", Font.BOLD, 30);
        g2d.setFont(font);
        g2d.setColor(new Color(50, 50, 50));

        // 绘制文本
        int x = 10;
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            g2d.drawString(String.valueOf(c), x, HEIGHT / 2 + font.getSize() / 2);
            x += font.getSize() + INTER_CHAR_SPACE;
        }

        // 添加干扰线
        for (int i = 0; i < LINE_COUNT; i++) {
            g2d.setColor(new Color(RANDOM.nextInt(256), RANDOM.nextInt(256), RANDOM.nextInt(256)));
            g2d.drawLine(RANDOM.nextInt(WIDTH), RANDOM.nextInt(HEIGHT), RANDOM.nextInt(WIDTH), RANDOM.nextInt(HEIGHT));
        }

        // 添加噪点
        for (int i = 0; i < NOISE_COUNT; i++) {
            int fx = RANDOM.nextInt(WIDTH);
            int fy = RANDOM.nextInt(HEIGHT);
            int rgb = RANDOM.nextInt(256);
            g2d.setColor(new Color(rgb, rgb, rgb));
            g2d.fillRect(fx, fy, 1, 1);
        }

        // 释放资源
        g2d.dispose();
        return image;
    }

    private static byte[] convertImageToByteArray(BufferedImage image, String formatName) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ImageIO.write(image, formatName, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

}
