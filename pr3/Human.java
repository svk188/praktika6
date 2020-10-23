package pr3;
class Human {
    class Head {
        String Hair = "Блондин";
        String Eyes = "Зелёные";
        public String getHair()
        {
            return Hair;
        }
        public String getEyes()
        {
            return Eyes;
        }
        public void setHair(String a){
            this.Hair = a;
        }
    }
    class Leg {
        int lenLeg = 70;
        public int getLeg()
        {
            return lenLeg;
        }
        public void Rost(int b){
            lenLeg = lenLeg + 1;
        }
    }
    class Hand{
        int lenHand = 30;
        public int getHand()
        {
            return lenHand;
        }
    }

}

class TestHuman {
    public static void main(String[] args) {
        Human Jack = new Human();
        Human.Head Hair = Jack.new Head();
        String hair = Hair.getHair();
        System.out.println("Цвет волос - " + hair);
        Human.Leg Len = Jack.new Leg();
        int lenleg = Len.getLeg();
        System.out.println("Длина ноги - " + lenleg);
        Human.Hand Len2 = Jack.new Hand();
        int lenhand = Len2.getHand();
        System.out.println("Длина руки - " + lenhand);
        Hair.setHair("Брюнет");
        String hair2 = Hair.getHair();
        System.out.println("Цвет волос - " + hair2);
    }
}