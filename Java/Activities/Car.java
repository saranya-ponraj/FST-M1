package Activities_java;


    public class Car {
        //Class Member Variables
        String color;
        int make;
        String transmission;
        int tyres;
        int doors;


        public void displayCharacterstics(){
            System.out.println("Color of the Car: " + color);
            System.out.println("Make of the Car: " + make);
            System.out.println("Transmission of the Car: " + transmission);

        }

        public void accelerate() {
            System.out.println("Car is moving forward.");
        }

        public void brake() {
            System.out.println("Car has stopped.");
        }
    }

