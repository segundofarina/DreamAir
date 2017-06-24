package itba.dreamair2.adapters;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import itba.dreamair2.httprequests.FlightsResponse;
import itba.dreamair2.MainActivity;
import itba.dreamair2.R;

/**
 * Created by segundofarina on 13/6/17.
 */







public class CustomCards extends RecyclerView.Adapter<CustomCards.ViewHolder> implements Serializable {

    String[] city;
    String[] price;
    String[] flight_number;
    String[] departure;
    Integer[] image;

    List<FlightsResponse.FlightsBean> flights;
    MainActivity activity;

    public CustomCards(  String[] city, String[] price, String[] flight_number,String[] departure, Integer[] image) {

        this.departure=departure;
        this.city=city;
        this.price=price;
        this.flight_number=flight_number;
        this.image = image;

    }

    public CustomCards(Activity activity,List<FlightsResponse.FlightsBean> flights) {
    this.activity=(MainActivity) activity;
    this.flights=flights;
    }

    class ViewHolder extends RecyclerView.ViewHolder{

            public ImageView image;
            public TextView city;
            public TextView price;
            public TextView departure;
            public TextView flight_number;

            public ViewHolder(View itemView) {
                super(itemView);
                image = (ImageView)itemView.findViewById(R.id.offer_image);
                city = (TextView)itemView.findViewById(R.id.offer_city);
                price = (TextView)itemView.findViewById(R.id.offer_price);
                departure = (TextView)itemView.findViewById(R.id.offer_departure);
                flight_number = (TextView)itemView.findViewById(R.id.offer_flight_number);


                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override public void onClick(View v) {
                        int position = getAdapterPosition();

                        //Snackbar.make(v, "Click detected on item " + position,
                        //        Snackbar.LENGTH_LONG)
                        //        .setAction("Action", null).show();
                        activity.loadFlightDetailFragment(flights.get(position));


                    }
                });
            }
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            View v = LayoutInflater.from(viewGroup.getContext())
                    .inflate(R.layout.offer_single, viewGroup, false);
            ViewHolder viewHolder = new ViewHolder(v);
            return viewHolder;
        }


    @Override
    public void onBindViewHolder(CustomCards.ViewHolder viewHolder, int i) {
        FlightsResponse.FlightsBean.OutboundRoutesBean.SegmentsBean info=flights.get(i).getOutbound_routes().get(0).getSegments().get(0);
        viewHolder.city.setText(info.getArrival().getAirport().getCity().getName().split(",")[0]);
        viewHolder.price.setText("US$ "+flights.get(i).getPrice().getTotal().getTotal()+"");


        //SimpleDateFormat output= new SimpleDateFormat("dd 'of' MM, yyyy");

        viewHolder.departure.setText(getStringDate(info.getDeparture().getDate()));
        viewHolder.flight_number.setText(info.getAirline().getId()+" "+info.getNumber());
        viewHolder.image.setImageResource(getImage(info.getArrival().getAirport().getCity().getId()));
    }

    public static String getStringDate(String str) {

        SimpleDateFormat input= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date day;
        try {
            day= input.parse(str);
        } catch (ParseException e) {
            day=null;
            e.printStackTrace();
        }
        Calendar cal= Calendar.getInstance();
        cal.setTime(day);
    String month;
        switch (cal.get(Calendar.MONTH)){
            case 0:
                month= "Enero";
                break;
            case 1:
                month= "Febrero";
                break;
            case 2:
                month= "Marzo";
                break;
            case 3:
                month= "Abril";
                break;
            case 4:
                month= "Mayo";
                break;
            case 5:
                month= "Junio";
                break;
            case 6:
                month= "Julio";
                break;
            case 7:
                month= "Agosto";
                break;
            case 8:
                month= "Septiembre";
                break;
            case 9:
                month= "Octubre";
                break;
            case 10:
                month= "Noviembre";
                break;
            case 11:
                month= "Diciembre";
                break;
            default:
                month=null;
                break;
        }

        String s=""+cal.get(Calendar.DAY_OF_MONTH)+" de "+month+", "+(cal.get(Calendar.YEAR));
        return s;
    }

    @Override
        public int getItemCount() {
            return flights.size();
        }

    private int getImage(String id){
        int image;
        switch(id){
            case "ASU":
                image=R.drawable.dest_asu;
                break;
            case "BCN":
                image=R.drawable.dest_bcn;
                break;
            case "BHI":
                image=R.drawable.dest_bhi;
                break;
            case "BOG":
                image=R.drawable.dest_bog;
                break;
            case "BRC":
                image=R.drawable.dest_brc;
                break;
            case "BUE":
                image=R.drawable.dest_bue;
                break;
            case "COR":
                image=R.drawable.dest_cor;
                break;
            case "CRD":
                image=R.drawable.dest_crd;
                break;
            case "CUN":
                image=R.drawable.dest_cun;
                break;
            case "FLN":
                image=R.drawable.dest_fln;
                break;
            case "FTE":
                image=R.drawable.dest_fte;
                break;
            case "IGR":
                image=R.drawable.dest_igr;
                break;
            case "JUJ":
                image=R.drawable.dest_juj;
                break;
            case "LAX":
                image=R.drawable.dest_lax;
                break;
            case "LIM":
                image=R.drawable.dest_lim;
                break;
            case "LON":
                image=R.drawable.dest_lon;
                break;
            case "MAD":
                image=R.drawable.dest_mad;
                break;
            case "MDZ":
                image=R.drawable.dest_mdz;
                break;
            case "MEX":
                image=R.drawable.dest_mex;
                break;
            case "MIA":
                image=R.drawable.dest_mia;
                break;
            case "MVD":
                image=R.drawable.dest_mvd;
                break;
            case "NQN":
                image=R.drawable.dest_nqn;
                break;
            case "NYC":
                image=R.drawable.dest_nyc;
                break;
            case "PAR":
                image=R.drawable.dest_par;
                break;
            case "PSS":
                image=R.drawable.dest_pss;
                break;
            case "REL":
                image=R.drawable.dest_rel;
                break;
            case "RGL":
                image=R.drawable.dest_rgl;
                break;
            case "RIO":
                image=R.drawable.dest_rio;
                break;
            case "SAO":
                image=R.drawable.dest_sao;
                break;
            case "SCL":
                image=R.drawable.dest_scl;
                break;
            case "SLA":
                image=R.drawable.dest_sla;
                break;
            case "TUC":
                image=R.drawable.dest_tuc;
                break;
            case "UAQ":
                image=R.drawable.dest_uaq;
                break;
            case "USH":
                image=R.drawable.dest_ush;
                break;
            default:
                image=R.drawable.dest_bue;
        }
        return image;
    }
    }



