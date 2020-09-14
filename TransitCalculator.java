public class TransitCalculator{
    int num_days; //# of days a person will be using the transit system
    int num_rides; //# of individual rides the person expects to take

    String[]options={"single ride", "7-day unlimited", "30-day unlimited"};
    double[]prices={2.75, 33.00, 127.00};

    public TransitCalculator(int days, int rides){
        num_days=days;
        num_rides=rides;
    }
    public double unlimited7Price(){
        int weeks=num_days/7;
        if(num_days%7>0){
            weeks+=1;
        }
        double total_cost= prices[1] * (double) weeks;
        double overall_price=total_cost/num_rides;
        return overall_price;

    }
    public double[] getRidePrices(){
        //price per ride for each fare option

        //OPTION #1: Single Ride
        double price_single=2.75;
        //OPTION #2: 7-day unlimited
        double price_7day=unlimited7Price();
        //OPTION #3: 30-day unlimited
        double price_30day=127.00/num_rides;

        double [] rideprice={price_single,price_7day,price_30day};
        return rideprice;
    }

    public String getBestFare(){
        double [] rideprice=getRidePrices();
        double min;
        int tracker=0;
        min=rideprice[0];
        for (int i=1; i<3; i++){
            if(min>rideprice[i]){
                min=rideprice[i];
                tracker=i;
            }

        }
        return "You should get the "+options[tracker]+" option at $"+ min +" per ride";
    }

    public static void main(String args[]){
        TransitCalculator NewYork=new TransitCalculator(5,12);
        System.out.println(NewYork.getBestFare());


    }


}
