package day12;

public class GenericsDemo {
	
	public static void main(String[] args) {
		
		Brush<Paint> redPaintBrush = PaintContainer.getPaintBrush(new RedPaint());
		System.out.println(redPaintBrush.getObj());
		
		Brush<Paint> bluePaintBrush = PaintContainer.getPaintBrush(new BluePaint());
		System.out.println(bluePaintBrush.getObj());
		
		Brush<Water> waterBrush = WaterContainer.getWaterBrush();
		System.out.println(waterBrush.getObj());
	}
}

class PaintContainer{
	public static Brush<Paint> getPaintBrush(Paint obj) {
		Brush<Paint> brush = new Brush<>();
		brush.setObj(obj);//if we set water obj to this brush, it will give runtime error
		return brush;
	}
}

class WaterContainer{
	public static Brush<Water> getWaterBrush() {
		Brush<Water>  brush = new Brush<>();
		brush.setObj(new Water());
		return brush;
	}
}

class Brush<T>{
	T obj;
	
	public void setObj(T obj) {
		this.obj = obj;
	}
	
	public T getObj() {
		return this.obj;
	}
	
}

abstract class Paint{}
class RedPaint extends Paint{}
class BluePaint extends Paint{}

class Water{}