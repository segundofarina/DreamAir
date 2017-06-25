package itba.dreamair2;

import android.content.res.Resources;
import android.os.Parcel;
import android.os.Parcelable;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import itba.dreamair2.httprequests.DealResponse;
import itba.dreamair2.httprequests.FlightsResponse;

/**
 * Created by segundofarina on 16/6/17.
 */

public class Flight implements Parcelable {

    private String departureCity;
    private String departureAirport;
    private String departureCityId;
    private String departureAirportId;
    private String departureTime;
    private String departureDate;

    private String arrivalCity;
    private String arrivalAirport;
    private String arrivalCityId;
    private String arrivalAirportId;
    private String arrivalTime;
    private String arrivalDate;

    private String duration;
    private String gate;
    private String status;
    private String number;
    private String airline;
    private String airlineID;

    private String price;

    private int airlineImg;
    private int destinationImg;

    private double latitude;
    private double longitude;


    public Flight(FlightsResponse.FlightsBean flight, DealResponse.DealsBean deal) {
        FlightsResponse.FlightsBean.OutboundRoutesBean.SegmentsBean info= flight.getOutbound_routes().get(0).getSegments().get(0);


        this.departureCity = info.getDeparture().getAirport().getCity().getName();
        this.departureAirport = info.getDeparture().getAirport().getDescription();
        this.departureCityId = info.getDeparture().getAirport().getCity().getId();
        this.departureAirportId = info.getDeparture().getAirport().getId();
        this.departureTime = getTime(info.getDeparture().getDate());
        this.departureDate = getStringDate(info.getDeparture().getDate());
        this.arrivalCity = info.getArrival().getAirport().getCity().getName();
        this.arrivalAirport= info.getArrival().getAirport().getDescription();
        this.arrivalCityId = info.getArrival().getAirport().getCity().getId();
        this.arrivalAirportId = info.getArrival().getAirport().getId();
        this.arrivalTime = getTime(info.getArrival().getDate());
        this.arrivalDate = getStringDate(info.getArrival().getDate());
        this.duration = info.getDuration();
        this.gate = "Buscando";
        this.status = "Buscando";
        this.airline = info.getAirline().getName();
        this.airlineID = info.getAirline().getId();
        this.number = airlineID+" "+info.getNumber()+"";
        this.airlineImg=getArilineImages(airlineID);
        this.destinationImg=getDestinationImages(arrivalCityId);
        this.price="US$ "+flight.getPrice().getTotal().getTotal()+"";
        this.latitude=deal.getCity().getLatitude();
        this.longitude=deal.getCity().getLongitude();
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    protected Flight(Parcel in) {
        departureCity = in.readString();
        departureAirport = in.readString();
        departureCityId = in.readString();
        departureAirportId = in.readString();
        departureTime = in.readString();
        departureDate = in.readString();
        arrivalCity = in.readString();
        arrivalAirport = in.readString();
        arrivalCityId = in.readString();
        arrivalAirportId = in.readString();
        arrivalTime = in.readString();
        arrivalDate = in.readString();
        duration = in.readString();
        gate = in.readString();
        status = in.readString();
        number = in.readString();
        airline = in.readString();
        airlineID = in.readString();
        price = in.readString();
        airlineImg = in.readInt();
        destinationImg = in.readInt();
    }

    public static final Creator<Flight> CREATOR = new Creator<Flight>() {
        @Override
        public Flight createFromParcel(Parcel in) {
            return new Flight(in);
        }

        @Override
        public Flight[] newArray(int size) {
            return new Flight[size];
        }
    };

    public String getPrice() {
        return price;
    }

    public int getAirlineImg() {
        return airlineImg;
    }

    public int getDestinationImg() {
        return destinationImg;
    }

    private int getArilineImages(String airlineID) {
        int image;
        switch(airlineID){
            case "AA":
                image=R.drawable.aa;
                break;
            case "AF":
                image=R.drawable.af;
                break;
            case "AM":
                image=R.drawable.am;
                break;
            case "AR":
                image=R.drawable.ar;
                break;
            case "AV":
                image=R.drawable.av;
                break;
            case "AZ":
                image=R.drawable.az;
                break;
            case "BA":
                image=R.drawable.ba;
                break;
            case "CM":
                image=R.drawable.cm;
                break;
            case "IB":
                image=R.drawable.ib;
                break;
            default:
                image=R.drawable.aa;
        }
        return image;
    }

    private int getDestinationImages(String arrivalCityId){

            int image;
            switch(arrivalCityId){
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

    public static String getTime(String str) {

        SimpleDateFormat input = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date day;
        try {
            day = input.parse(str);
        } catch (ParseException e) {
            day = null;
            e.printStackTrace();
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(day);


        return cal.get(Calendar.HOUR)+":"+cal.get(Calendar.MINUTE);
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
//
//
//
//
//        String[] months = Resources.getSystem().getStringArray(R.array.MONTHS);
//        String month = months[cal.get(Calendar.MONTH)];
//
//        String month;
//        switch (cal.get(Calendar.MONTH)){
//            case Calendar.JANUARY:
//                month= Resources.getSystem().getString(R.string.JANUARY);
//                break;
//            case Calendar.FEBRUARY:
//                month= Resources.getSystem().getString(R.string.FEBRUARY);
//                break;
//            case Calendar.MARCH:
//                month= Resources.getSystem().getString(R.string.MARCH);
//                break;
//            case Calendar.APRIL:
//                month= Resources.getSystem().getString(R.string.APRIL);
//                break;
//            case Calendar.MAY:
//                month= Resources.getSystem().getString(R.string.MAY);
//                break;
//            case Calendar.JUNE:
//                month= Resources.getSystem().getString(R.string.JUNE);
//                break;
//            case Calendar.JULY:
//                month= Resources.getSystem().getString(R.string.JULY);
//                break;
//            case Calendar.AUGUST:
//                month= Resources.getSystem().getString(R.string.AUGUST);
//                break;
//            case Calendar.SEPTEMBER:
//                month= Resources.getSystem().getString(R.string.SEPTEMBER);
//                break;
//            case Calendar.OCTOBER:
//                month= Resources.getSystem().getString(R.string.OCTOBER);
//                break;
//            case Calendar.NOVEMBER:
//                month= Resources.getSystem().getString(R.string.NOVEMBER);
//                break;
//            case Calendar.DECEMBER:
//                month= Resources.getSystem().getString(R.string.DECEMBER);
//                break;
//            default:
//                month=null;
//                break;
//        }
        String month = "HOLA";

        String s=""+cal.get(Calendar.DAY_OF_MONTH)+" de "+month+", "+(cal.get(Calendar.YEAR));
        return s;
    }


    public String getDepartureCity() {
        return departureCity;
    }

    public String getDepartureAirport() {
        return departureAirport;
    }

    public String getDepartureCityId() {
        return departureCityId;
    }

    public String getDepartureAirportId() {
        return departureAirportId;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public String getArrivalCity() {
        return arrivalCity;
    }

    public String getArrivalAirport() {
        return arrivalAirport;
    }

    public String getArrivalCityId() {
        return arrivalCityId;
    }

    public String getArrivalAirportId() {
        return arrivalAirportId;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public String getArrivalDate() {
        return arrivalDate;
    }

    public String getDuration() {
        return duration;
    }

    public String getGate() {
        return gate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getNumber() {
        return number;
    }

    public String getAirline() {
        return airline;
    }

    public String getAirlineID() {
        return airlineID;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(departureCity);
        dest.writeString(departureAirport);
        dest.writeString(departureCityId);
        dest.writeString(departureAirportId);
        dest.writeString(departureTime);
        dest.writeString(departureDate);
        dest.writeString(arrivalCity);
        dest.writeString(arrivalAirport);
        dest.writeString(arrivalCityId);
        dest.writeString(arrivalAirportId);
        dest.writeString(arrivalTime);
        dest.writeString(arrivalDate);
        dest.writeString(duration);
        dest.writeString(gate);
        dest.writeString(status);
        dest.writeString(number);
        dest.writeString(airline);
        dest.writeString(airlineID);
        dest.writeString(price);
        dest.writeInt(airlineImg);
        dest.writeInt(destinationImg);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Flight flight = (Flight) o;

        if (!number.equals(flight.number)) return false;
        return price.equals(flight.price);

    }

    @Override
    public int hashCode() {
        int result = departureCity.hashCode();
        result = 31 * result + departureAirport.hashCode();
        result = 31 * result + departureCityId.hashCode();
        result = 31 * result + departureAirportId.hashCode();
        result = 31 * result + departureTime.hashCode();
        result = 31 * result + departureDate.hashCode();
        result = 31 * result + arrivalCity.hashCode();
        result = 31 * result + arrivalAirport.hashCode();
        result = 31 * result + arrivalCityId.hashCode();
        result = 31 * result + arrivalAirportId.hashCode();
        result = 31 * result + (arrivalTime != null ? arrivalTime.hashCode() : 0);
        result = 31 * result + (arrivalDate != null ? arrivalDate.hashCode() : 0);
        result = 31 * result + duration.hashCode();
        result = 31 * result + (gate != null ? gate.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + number.hashCode();
        result = 31 * result + airline.hashCode();
        result = 31 * result + airlineID.hashCode();
        result = 31 * result + price.hashCode();
        result = 31 * result + airlineImg;
        result = 31 * result + destinationImg;
        return result;
    }

    @Override
    public String toString() {
        return departureAirportId +" "+departureDate+" "+arrivalCity;
    }
}
