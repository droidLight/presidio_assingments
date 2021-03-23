package day12;

import java.lang.reflect.Field;

public class GenericWithAnnotation {
	
	public static void main(String[] args) throws Exception{
		
		BrushNew<PaintNew> redPaintNewBrushNew = PaintContainerNew.getPaintNewBrush(new RedPaintNew());
		System.out.println(redPaintNewBrushNew.getObj());
		
		BrushNew<PaintNew> bluePaintNewBrushNew = PaintContainerNew.getPaintNewBrush(new BluePaintNew());
		System.out.println(bluePaintNewBrushNew.getObj());
		
		BrushNew<WaterNew> waterBrushNew = WaterContainerNew.getWaterBrush();
		System.out.println(waterBrushNew.getObj());
	}
}

class PaintContainerNew{
	public static BrushNew<PaintNew> getPaintNewBrush(PaintNew obj) throws Exception{
		BrushNew<PaintNew> brush = new BrushNew<>();
		Field field = brush.getClass().getDeclaredField("obj");
		field.setAccessible(true);
		PaintAnnotation paintAnnotation = field.getAnnotation(PaintAnnotation.class);
		if(paintAnnotation != null) {
			brush.setObj(obj);//if we set water obj to this BrushNew, it will give runtime error
		}else {
			System.out.println("No need for dependency injection - paint container");
		}
		
		return brush;
	}
}

class WaterContainerNew{
	public static BrushNew<WaterNew> getWaterBrush() throws Exception{
		BrushNew<WaterNew>  brush = new BrushNew<>();
		Field field = brush.getClass().getDeclaredField("obj");
		field.setAccessible(true);
		PaintAnnotation paintAnnotation = field.getAnnotation(PaintAnnotation.class);
		if(paintAnnotation != null) {
			brush.setObj(new WaterNew());
		}else {
			System.out.println("No need for dependency injection - water conatainer");
		}
		return brush;
	}
}

class BrushNew<T>{
	//@PaintAnnotation
	T obj;
	
	public void setObj(T obj) {
		this.obj = obj;
	}
	
	public T getObj() {
		return this.obj;
	}
	
}

abstract class PaintNew{}
class RedPaintNew extends PaintNew{}
class BluePaintNew extends PaintNew{}

class WaterNew{}