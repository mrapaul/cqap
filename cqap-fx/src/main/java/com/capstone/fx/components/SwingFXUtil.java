package com.capstone.fx.components;

import javafx.scene.image.*;
import sun.awt.image.*;

import java.awt.*;
import java.awt.image.*;
import java.nio.*;

public class SwingFXUtil
{
    public static WritableImage toFXImage(BufferedImage bimg,
                                          WritableImage wimg)
    {
        int bw = bimg.getWidth();
        int bh = bimg.getHeight();
        switch (bimg.getType())
        {
            case BufferedImage.TYPE_INT_ARGB:
            case BufferedImage.TYPE_INT_ARGB_PRE:
                break;
            default:
                BufferedImage converted = new BufferedImage(bw, bh,

                        BufferedImage.TYPE_INT_ARGB_PRE);
                Graphics2D g2d = converted.createGraphics();
                g2d.drawImage(bimg, 0, 0, null);
                g2d.dispose();
                bimg = converted;
                break;
        }
        // assert(bimg.getType == TYPE_INT_ARGB[_PRE]);
        if (wimg != null)
        {
            int iw = (int) wimg.getWidth();
            int ih = (int) wimg.getHeight();
            if (iw < bw || ih < bh)
            {
                wimg = null;
            }
            else if (bw < iw || bh < ih)
            {
                int empty[] = new int[iw];
                PixelWriter pw = wimg.getPixelWriter();
                PixelFormat pf = PixelFormat.getIntArgbPreInstance();
                if (bw < iw)
                {
                    pw.setPixels(bw, 0, iw - bw, bh, pf, empty, 0, 0);
                }
                if (bh < ih)
                {
                    pw.setPixels(0, bh, iw, ih - bh, pf, empty, 0, 0);
                }
            }
        }
        if (wimg == null)
        {
            wimg = new WritableImage(bw, bh);
        }
        PixelWriter pw = wimg.getPixelWriter();
        IntegerComponentRaster icr = (IntegerComponentRaster) bimg
                .getRaster();
        int data[] = icr.getDataStorage();
        int offset = icr.getDataOffset(0);
        int scan = icr.getScanlineStride();
        PixelFormat<IntBuffer> pf = (bimg.isAlphaPremultiplied() ? PixelFormat
                .getIntArgbPreInstance() : PixelFormat.getIntArgbInstance());
        pw.setPixels(0, 0, bw, bh, pf, data, offset, scan);
        return wimg;
    }
}
