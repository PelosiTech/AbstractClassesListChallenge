/**
 * Author: Carlo Pelosi
 * Date: 12/20/2019
 * Time: 2 hours
 */
public class Main {
        public static void main(String[] args) {
                LList arizonaList = new LList(null);
                String stringData = "Amado Gilbert Morenci Chandler Cutter Summerhaven Peoria Carefree QueenCreek Moccasin Dudleyville Phoenix Scottsdale Mesa Anthem Nolic";
                String[] data = stringData.split(" ");
                for (String s : data){
                        arizonaList.addItem(new Node(s));
                }
                arizonaList.traverse(arizonaList.getHead());
                System.out.println("########################################################################");
                LList numberList = new LList(null);
                String stringData2 = "7 8 4 6 9 1 7 2 0 3 5";
                String[] data2 = stringData2.split(" ");
                for (String s : data2){
                        numberList.addItem(new Node(s));
                }
                numberList.traverse(numberList.getHead());
                numberList.removeItem(new Node("4"));
                numberList.removeItem(new Node("3"));
                numberList.removeItem(new Node("2"));
                numberList.removeItem(new Node("1"));
                numberList.traverse(numberList.getHead());
        }
}