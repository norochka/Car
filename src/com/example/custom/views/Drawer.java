package com.example.custom.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import static com.example.utils.Utils.log;

public class Drawer extends View {

	private Paint paint;
	private float x, y, downX, downY;

	public Drawer(Context context) {
		super(context);
		init();

	}

	public Drawer(Context context, AttributeSet attrs) {
		super(context, attrs);
		init();
	}

	public Drawer(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		init();
	}

	/**
	 * initialization of paint(brush)
	 */
	private void init() {
		paint = new Paint();
		paint.setStrokeWidth(5);
		paint.setColor(Color.BLUE);
		paint.setStyle(Paint.Style.STROKE);
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		switch (event.getAction()) {
		case MotionEvent.ACTION_DOWN:
			log("Down");
			downX = event.getX();
			downY = event.getY();
			invalidate();
			break;
		case MotionEvent.ACTION_UP:
			log("Up");
			break;

		case MotionEvent.ACTION_MOVE:
			log(event.getX() + " " + event.getY());
			x = event.getX();
			y = event.getY();
			invalidate();
			break;

		default:
			break;
		}

		return true;

	}

	/**
	 * Draw a rectangle,circul, line
	 */
	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		canvas.drawRect(downX, downY, x, y, paint);
		if(downX>x && downY>y){
			canvas.drawRect(x,y, downX, downY, paint);
		}
		if(downX>x && downY<y){
			canvas.drawRect(x,downY,downX,y, paint);
		}
		if(downX<x && downY>y){
			canvas.drawRect(downX,y,x,downY, paint);
		}
		canvas.drawCircle(500, 800, 100, paint);
		canvas.drawLine(0, 0, canvas.getWidth(), canvas.getHeight() / 2, paint);

	}
}
