package com.example.catan;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.SurfaceView;

public class BoardView extends SurfaceView {

    //create paints for drawing the different hexes
    Paint edgePaint = new Paint();
    Paint forestPaint = new Paint();
    Paint mountainPaint = new Paint();
    Paint hillsPaint = new Paint();
    Paint fieldPaint = new Paint();
    Paint pasturePaint = new Paint();
    //create paints for drawing each player's infrastructure
    //for now I'm just going to change the color when I need to draw a new player's buildings
    Paint buildings = new Paint();

    /*
    I want to apologize in advance for needing to see this
    these constants are the x and y coordinates of every
    intersection on the board in order to make drawing things like settlements
    and roads much easier. Starting on the left of the board and moving left are x0-x11
    and starting on the top and going down are y0-y11
     */
    //TODO make these final
    public final float X0 = 732;
    public final float X1 = 785;
    public final float X2 = 838;
    public final float X3 = 891;
    public final float X4 = 944;
    public final float X5 = 997;
    public final float X6 = 1050;
    public final float X7 = 1103;
    public final float X8 = 1156;
    public final float X9 = 1209;
    public final float X10 = 1262;
    public final float Y0 = 0;
    public final float Y1 = 31;
    public final float Y2 = 93;
    public final float Y3 = 124;
    public final float Y4 = 186;
    public final float Y5 = 217;
    public final float Y6 = 279;
    public final float Y7 = 310;
    public final float Y8 = 372;
    public final float Y9 = 403;
    public final float Y10 = 465;
    public final float Y11 = 496;

    public BoardView(Context context, AttributeSet attrs) {
        super(context, attrs);

        //why is this not false by default?
        setWillNotDraw(false);

        //create palettes
        edgePaint.setColor(0xFF000000);
        edgePaint.setStyle(Paint.Style.FILL_AND_STROKE);

        setBackgroundColor(Color.WHITE);//better than the weird default grey
    }//end constructor

    private void drawHex(Canvas canvas, Paint paint, float[] p) {
        //the following was brought to you in part by java's terrible array architecture
        float x1 = p[0];
        float y1 = p[1];
        float x2 = p[2];
        float y2 = p[3];
        float x3 = p[4];
        float y3 = p[5];
        float x4 = p[6];
        float y4 = p[7];
        float x5 = p[8];
        float y5 = p[9];
        float x6 = p[10];
        float y6 = p[11];
        float[] lineCords = new float[]
                {x1, y1, x2, y2, x2, y2, x3, y3, x3, y3, x4, y4,
                x4, y4, x5, y5, x5, y5, x6, y6, x6, y6, x1, y1};
        canvas.drawLines(lineCords, paint);
    }

    @Override
    public void onDraw(Canvas canvas) {
        drawHex(canvas, edgePaint, new float[]{X2,Y1,X3,Y0,X4,Y1,X4,Y2,X3,Y3,X2,Y2});
        drawHex(canvas, edgePaint, new float[]{X4,Y1,X5,Y0,X6,Y1,X6,Y2,X5,Y3,X4,Y2});
        drawHex(canvas, edgePaint, new float[]{X6,Y1,X7,Y0,X8,Y1,X8,Y2,X7,Y3,X6,Y2});//3
        drawHex(canvas, edgePaint, new float[]{X1,Y3,X2,Y2,X3,Y3,X3,Y4,X2,Y5,X1,Y4});
        drawHex(canvas, edgePaint, new float[]{X3,Y3,X4,Y2,X5,Y3,X5,Y4,X4,Y5,X3,Y4});
        drawHex(canvas, edgePaint, new float[]{X5,Y3,X6,Y2,X7,Y3,X7,Y4,X6,Y5,X5,Y4});
        drawHex(canvas, edgePaint, new float[]{X7,Y3,X8,Y2,X9,Y3,X9,Y4,X8,Y5,X7,Y4});//7
        drawHex(canvas, edgePaint, new float[]{X0,Y5,X1,Y4,X2,Y5,X2,Y6,X1,Y7,X0,Y6});
        drawHex(canvas, edgePaint, new float[]{X2,Y5,X3,Y4,X4,Y5,X4,Y6,X3,Y7,X2,Y6});
        drawHex(canvas, edgePaint, new float[]{X4,Y5,X5,Y4,X6,Y5,X6,Y6,X5,Y7,X4,Y6});
        drawHex(canvas, edgePaint, new float[]{X6,Y5,X7,Y4,X8,Y5,X8,Y6,X7,Y7,X6,Y6});
        drawHex(canvas, edgePaint, new float[]{X8,Y5,X9,Y4,X10,Y5,X10,Y6,X9,Y7,X8,Y6});//12
        drawHex(canvas, edgePaint, new float[]{X1,Y7,X2,Y6,X3,Y7,X3,Y8,X2,Y9,X1,Y8});
        drawHex(canvas, edgePaint, new float[]{X3,Y7,X4,Y6,X5,Y7,X5,Y8,X4,Y9,X3,Y8});
        drawHex(canvas, edgePaint, new float[]{X5,Y7,X6,Y6,X7,Y7,X7,Y8,X6,Y9,X5,Y8});
        drawHex(canvas, edgePaint, new float[]{X7,Y7,X8,Y6,X9,Y7,X9,Y8,X8,Y9,X7,Y8});//16
        drawHex(canvas, edgePaint, new float[]{X2,Y9,X3,Y8,X4,Y9,X4,Y10,X3,Y11,X2,Y10});
        drawHex(canvas, edgePaint, new float[]{X4,Y9,X5,Y8,X6,Y9,X6,Y10,X5,Y11,X4,Y10});
        drawHex(canvas, edgePaint, new float[]{X6,Y9,X7,Y8,X8,Y9,X8,Y10,X7,Y11,X6,Y10});
    }//onDraw
}//class BoardView
