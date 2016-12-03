package de.schueler.layoutviewsdemo.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import de.schueler.layoutviewsdemo.R;

public class NumberLine extends View {
    private static final String ZERO_STRING = String.valueOf(0);

    private int textColor;
    private int hightlightColor;
    private int number;

    private int numberMax;

    private int width;
    private int height;
    private int halfWidth;
    private int halfHeight;
    private int vLineStart;
    private int vLineEnd;
    private int startVLine;
    private int endVLine;
    private int numberVLineX;

    private String numberString;
    private String numberMaxString;
    private String numberMinString;

    private final Paint hightlightPaint;
    private final Paint textPaint;
    private final Paint hLinePaint;
    private final Paint vLinePaint;

    public NumberLine(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        TypedArray array = context.getTheme().obtainStyledAttributes(attrs, R.styleable.NumberLine, 0, 0);

        try {
            textColor = array.getColor(R.styleable.NumberLine_textColor, 0);
            hightlightColor = array.getColor(R.styleable.NumberLine_highlightColor, 0xFFFF0000);
        } finally {
            array.recycle();
        }

        hightlightPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        hightlightPaint.setColor(hightlightColor);
        hightlightPaint.setTextSize(18);

        textPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        textPaint.setColor(textColor);
        textPaint.setTextSize(18);

        hLinePaint = new Paint();

        vLinePaint = new Paint();
        vLinePaint.setStrokeWidth(3);

        setNumber(0);
    }

    private void recalculate() {
        int w = getWidth();
        int h = getHeight();

        width = w;
        height = h;
        halfWidth = w / 2;
        halfHeight = h / 2;
        vLineStart = h / 4;
        vLineEnd = (h * 3) / 4;
        startVLine = w / 10;
        endVLine = (w * 9) / 10;

        {
            numberVLineX = halfWidth;
            if (number > 0) {
                numberVLineX += ((w * 4) / 10) / 2;
            } else if (number < 0) {
                numberVLineX -= ((w * 4) / 10) / 2;
            } else {
                numberVLineX = halfWidth;
            }
        }
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        recalculate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawLine(0, halfHeight, width, halfHeight, hLinePaint);
        canvas.drawLine(halfWidth, vLineStart, halfWidth, vLineEnd, vLinePaint);
        canvas.drawLine(startVLine, vLineStart, startVLine, vLineEnd, vLinePaint);
        canvas.drawLine(endVLine, vLineStart, endVLine, vLineEnd, vLinePaint);
        canvas.drawLine(numberVLineX, vLineStart, numberVLineX, vLineEnd, vLinePaint);
        if (number != 0) {
            canvas.drawText(ZERO_STRING, halfWidth - 4, height, textPaint);
        }
        canvas.drawText(numberMinString, startVLine - 5, height, textPaint);
        canvas.drawText(numberMaxString, endVLine - 5, height, textPaint);
        canvas.drawText(numberString, numberVLineX - 5, height, hightlightPaint);
    }

    public int getTextColor() {
        return textColor;
    }

    public void setTextColor(int textColor) {
        this.textColor = textColor;
        textPaint.setColor(textColor);
        invalidate();
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
        numberMax = 2 * Math.abs(number);
        if (number == 0) {
            numberMax = 1;
        }
        numberString = String.valueOf(number);
        numberMaxString = String.valueOf(numberMax);
        numberMinString = String.valueOf(-numberMax);
        recalculate();
        invalidate();
    }
}
