package itba.dreamair2;

import android.os.Parcel;
import android.os.Parcelable;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

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


    public Flight(FlightsResponse.FlightsBean flight) {
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
        return R.drawable.aa;
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
        String month;
        switch (cal.get(Calendar.MONTH)){
            case Calendar.JANUARY:
                month= "Enero";
                break;
            case Calendar.FEBRUARY:
                month= "Febrero";
                break;
            case Calendar.MARCH:
                month= "Marzo";
                break;
            case Calendar.APRIL:
                month= "Abril";
                break;
            case Calendar.MAY:
                month= "Mayo";
                break;
            case Calendar.JUNE:
                month= "Junio";
                break;
            case Calendar.JULY:
                month= "Julio";
                break;
            case Calendar.AUGUST:
                month= "Agosto";
                break;
            case Calendar.SEPTEMBER:
                month= "Septiembre";
                break;
            case Calendar.OCTOBER:
                month= "Octubre";
                break;
            case Calendar.NOVEMBER:
                month= "Noviembre";
                break;
            case Calendar.DECEMBER:
                month= "Diciembre";
                break;
            default:
                month=null;
                break;
        }

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

        if (airlineImg != flight.airlineImg) return false;
        if (destinationImg != flight.destinationImg) return false;
        if (!departureCity.equals(flight.departureCity)) return false;
        if (!departureAirport.equals(flight.departureAirport)) return false;
        if (!departureCityId.equals(flight.departureCityId)) return false;
        if (!departureAirportId.equals(flight.departureAirportId)) return false;
        if (!departureTime.equals(flight.departureTime)) return false;
        if (!departureDate.equals(flight.departureDate)) return false;
        if (!arrivalCity.equals(flight.arrivalCity)) return false;
        if (!arrivalAirport.equals(flight.arrivalAirport)) return false;
        if (!arrivalCityId.equals(flight.arrivalCityId)) return false;
        if (!arrivalAirportId.equals(flight.arrivalAirportId)) return false;
        if (arrivalTime != null ? !arrivalTime.equals(flight.arrivalTime) : flight.arrivalTime != null)
            return false;
        if (arrivalDate != null ? !arrivalDate.equals(flight.arrivalDate) : flight.arrivalDate != null)
            return false;
        if (!duration.equals(flight.duration)) return false;
        if (gate != null ? !gate.equals(flight.gate) : flight.gate != null) return false;
        if (status != null ? !status.equals(flight.status) : flight.status != null) return false;
        if (!number.equals(flight.number)) return false;
        if (!airline.equals(flight.airline)) return false;
        if (!airlineID.equals(flight.airlineID)) return false;
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
