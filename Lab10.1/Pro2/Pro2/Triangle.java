package Pro2;

public class Triangle
    extends GeometricObject{
        private double side1 = 1.0;
        private double side2 = 1.0;
        private double side3 = 1.0;

        public Triangle() {
        }

        public Triangle(double side1, double side2, double side3) 
            throws IllegalTriangleException {
            if (side1 + side2 <= side3 || 
                side1 + side3 <= side2 || 
                side2 + side3 <= side1) 
                throw new IllegalTriangleException(side1, side2, side3);
		this.side1 = side1;
		this.side2 = side2;
		this.side3 = side3;
	}

        public double setSide1() {
            return side1;
        }

        public double setSide2() {
            return side2;
        }

        public double setSide3() {
            return side3;
        }

        public void setSide1(double side1) {
            this.side1 = side1;
        }

        public void setSide2(double side2) {
            this.side2 = side2;
        }

        public void setSide3(double side3) {
            this.side3 = side2;
        }

        public double getArea() {
            double s = (side1 + side2 + side3) / 2;
		    return Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
        }

        public double getPerimeter() {
            return side1 + side2 + side3;
        }

        public String toString() {
            return " Triangle\nSide 1 = " + side1 + " Side 2 = " + side2
                    + " Side 3 = " + side3;
        }
}