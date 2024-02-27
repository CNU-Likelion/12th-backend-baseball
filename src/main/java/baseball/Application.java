package baseball;

public class Application {
    public static void main(String[] args) {
         Random random = new Random();
        Scanner sc = new Scanner(System.in);

        System.out.println("게임을 시작하려면 s 입력");
        String answer = sc.nextLine();

        while (answer.equals("s")){



            System.out.println("game start !");

            int a[] = new int[3];
            int b[] = new int[3];

            for (int i = 0; i < a.length; i++){
                a[i] = random.nextInt(9)+1;
                while(a[0]==0){
                    a[0] = random.nextInt(9)+1;
                }
            }

            int strike = 0;
            int ball = 0;


            while (true){
                System.out.println("세 자리 수 입력 >> ");
                String c = sc.nextLine();


                //예외처리

                for (int i = 0; i < b.length; i++) {
                    b[i] = c.charAt(i)-48;


                }
                for (int i = 0; i < b.length; i++) {
                    for (int j = 0; j < b.length; j++) {
                        if(a[i]==b[i]){
                            if(i==j){
                                strike++;
                            }
                            else {
                                ball++;
                            }
                        }

                    }

                }
                if(strike==0 && ball==0){
                    System.out.println("nothing !");
                }
                else{
                    System.out.println("스트라이크 : "+strike+" 볼 : "+ball);
                }

                if(strike==3){
                    break;
                }


            }
            System.out.println("종료 [e] , 다시 게임하기 [s]를 입력해주세요");
            answer = sc.nextLine();

        }







    }
}
