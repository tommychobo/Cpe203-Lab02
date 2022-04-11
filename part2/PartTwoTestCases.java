import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import org.junit.Test;

public class PartTwoTestCases
{
   public static final double DELTA = 0.00001;

   @Test
   public void testCircleImplSpecifics()
      throws NoSuchMethodException
   {
      final List<String> expectedMethodNames = Arrays.asList(
         "getCenter", "getRadius", "perimeter");

      final List<Class> expectedMethodReturns = Arrays.asList(
         Point.class, double.class, double.class);

      final List<Class[]> expectedMethodParameters = Arrays.asList(
         new Class[0], new Class[0], new Class[0]);

      verifyImplSpecifics(Circle.class, expectedMethodNames,
         expectedMethodReturns, expectedMethodParameters);
   }

   @Test
   public void testRectangleImplSpecifics()
      throws NoSuchMethodException
   {
      final List<String> expectedMethodNames = Arrays.asList(
         "getTopLeft", "getBottomRight", "perimeter");

      final List<Class> expectedMethodReturns = Arrays.asList(
         Point.class, Point.class, double.class);

      final List<Class[]> expectedMethodParameters = Arrays.asList(
         new Class[0], new Class[0], new Class[0]);

      verifyImplSpecifics(Rectangle.class, expectedMethodNames,
         expectedMethodReturns, expectedMethodParameters);
   }

   @Test
   public void testPolygonImplSpecifics()
      throws NoSuchMethodException
   {
      final List<String> expectedMethodNames = Arrays.asList(
         "getPoints", "perimeter");

      final List<Class> expectedMethodReturns = Arrays.asList(
         List.class, double.class);

      final List<Class[]> expectedMethodParameters = Arrays.asList(
         new Class[0], new Class[0]);

      verifyImplSpecifics(Polygon.class, expectedMethodNames,
         expectedMethodReturns, expectedMethodParameters);
   }

   @Test
   public void testPerimCircle(){
      Circle c = new Circle(new Point(5.0, 5.0), 20.0/Math.PI);
      assertEquals(40.0, c.perimeter(), DELTA);
   }

   @Test
   public void testPerimRectangle(){
      Rectangle r = new Rectangle(new Point(0, 5), new Point(5, 0));
      assertEquals(20.0, r.perimeter(), DELTA);
   }

   @Test
   public void testPerimPolygon(){
      ArrayList<Point> points = new ArrayList<>();
      points.add(new Point(0, 0));
      points.add(new Point(9, 12)); //15
      points.add(new Point(20, 12)); //11
      points.add(new Point(11, 0)); //15
      Polygon p = new Polygon(points);
      assertEquals(52.0, p.perimeter(), DELTA);
   }

   @Test
   public void testPerimCircle2(){
      Circle c = new Circle(new Point(1, 1), 2);
      assertEquals(12.5663706, c.perimeter(), DELTA);
   }

   @Test
   public void testPerimRectangle2(){
      Rectangle r = new Rectangle(new Point(-1.0, 2.0), new Point(1.0, -1.6));
      assertEquals(11.2, r.perimeter(), DELTA);
   }

   @Test
   public void testPerimPolygon2(){
      Polygon p = new Polygon(new ArrayList<>(Arrays.asList(
              new Point(0, 0),
              new Point(3, 1),
              new Point(1, 4),
              new Point(-1, 4)
      )));
      assertEquals(12.8909345, p.perimeter(), DELTA);
   }

   @Test
   public void testBigger(){
      Circle c = new Circle(new Point(1.0, 1.0), 2.0);
      Rectangle r = new Rectangle(new Point(-1.0, 2.0), new Point(1.0, -1.6));
      Polygon p = new Polygon(new ArrayList<>(Arrays.asList(
              new Point(0, 0),
              new Point(3, 1),
              new Point(1, 4),
              new Point(-1, 4)
      )));
      /*System.out.println("Circle: "+Util.perimeter(c)
              +"\nRectangle: "+Util.perimeter(r)
              +"\nPolygon: "+Util.perimeter(p)
              +"\nBiggest: "+Bigger.whichIsBigger(c, r, p));*/
      assertEquals(12.8909345, Bigger.whichIsBigger(c, r, p), DELTA);
   }

   private static void verifyImplSpecifics(
      final Class<?> clazz,
      final List<String> expectedMethodNames,
      final List<Class> expectedMethodReturns,
      final List<Class[]> expectedMethodParameters)
      throws NoSuchMethodException
   {
      assertEquals("Unexpected number of public fields",
         0, clazz.getFields().length);

      final List<Method> publicMethods = Arrays.stream(
         clazz.getDeclaredMethods())
            .filter(m -> Modifier.isPublic(m.getModifiers()))
            .collect(Collectors.toList());

      assertEquals("Unexpected number of public methods",
         expectedMethodNames.size(), publicMethods.size());

      assertTrue("Invalid test configuration",
         expectedMethodNames.size() == expectedMethodReturns.size());
      assertTrue("Invalid test configuration",
         expectedMethodNames.size() == expectedMethodParameters.size());

      for (int i = 0; i < expectedMethodNames.size(); i++)
      {
         Method method = clazz.getDeclaredMethod(expectedMethodNames.get(i),
            expectedMethodParameters.get(i));
         assertEquals(expectedMethodReturns.get(i), method.getReturnType());
      }
   }
}
