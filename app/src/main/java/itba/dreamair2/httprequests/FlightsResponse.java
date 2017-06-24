package itba.dreamair2.httprequests;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.List;

/**
 * Created by segundofarina on 16/6/17.
 */

public class FlightsResponse {

    /**
     * meta : {"uuid":"d54eaedb-e0df-4629-9ebb-62a69d9197e1","time":"1203.467697ms"}
     * page : 1
     * page_size : 30
     * total : 3
     * currency : {"id":"USD"}
     * flights : [{"price":{"adults":{"base_fare":278,"quantity":1},"children":null,"infants":null,"total":{"charges":11.12,"taxes":55.6,"fare":278,"total":344.72}},"outbound_routes":[{"segments":[{"arrival":{"date":"2017-12-25 07:09:00","airport":{"id":"TUC","description":"Aeropuerto Benjamin Matienzo, San Miguel de Tucuman, Argentina","time_zone":"-03:00","city":{"id":"TUC","name":"San Miguel de Tucuman, Tucuman","country":{"id":"AR","name":"Argentina"}}}},"departure":{"date":"2017-12-25 05:50:00","airport":{"id":"EZE","description":"Aeropuerto Ezeiza Ministro Pistarini, Buenos Aires, Argentina","time_zone":"-03:00","city":{"id":"BUE","name":"Buenos Aires, Ciudad de Buenos Aires","country":{"id":"AR","name":"Argentina"}}}},"id":94588,"number":8700,"cabin_type":"ECONOMY","airline":{"id":"8R","name":"SOL","rating":1.55},"duration":"01:19","stopovers":[]}],"duration":"01:19"}]},{"price":{"adults":{"base_fare":293,"quantity":1},"children":null,"infants":null,"total":{"charges":11.72,"taxes":58.6,"fare":293,"total":363.32}},"outbound_routes":[{"segments":[{"arrival":{"date":"2017-12-25 08:37:00","airport":{"id":"TUC","description":"Aeropuerto Benjamin Matienzo, San Miguel de Tucuman, Argentina","time_zone":"-03:00","city":{"id":"TUC","name":"San Miguel de Tucuman, Tucuman","country":{"id":"AR","name":"Argentina"}}}},"departure":{"date":"2017-12-25 07:20:00","airport":{"id":"EZE","description":"Aeropuerto Ezeiza Ministro Pistarini, Buenos Aires, Argentina","time_zone":"-03:00","city":{"id":"BUE","name":"Buenos Aires, Ciudad de Buenos Aires","country":{"id":"AR","name":"Argentina"}}}},"id":94592,"number":2874,"cabin_type":"ECONOMY","airline":{"id":"8R","name":"SOL","rating":1.55},"duration":"01:17","stopovers":[]}],"duration":"01:17"}]},{"price":{"adults":{"base_fare":266,"quantity":1},"children":null,"infants":null,"total":{"charges":10.64,"taxes":53.2,"fare":266,"total":329.84}},"outbound_routes":[{"segments":[{"arrival":{"date":"2017-12-25 22:06:00","airport":{"id":"TUC","description":"Aeropuerto Benjamin Matienzo, San Miguel de Tucuman, Argentina","time_zone":"-03:00","city":{"id":"TUC","name":"San Miguel de Tucuman, Tucuman","country":{"id":"AR","name":"Argentina"}}}},"departure":{"date":"2017-12-25 20:50:00","airport":{"id":"AEP","description":"Aeropuerto Jorge Newbery, Buenos Aires, Argentina","time_zone":"-03:00","city":{"id":"BUE","name":"Buenos Aires, Ciudad de Buenos Aires","country":{"id":"AR","name":"Argentina"}}}},"id":94660,"number":9738,"cabin_type":"ECONOMY","airline":{"id":"8R","name":"SOL","rating":1.55},"duration":"01:16","stopovers":[]}],"duration":"01:16"}]}]
     * filters : [{"key":"airline","values":[{"id":"8R","name":"SOL","logo":"http://hci.it.itba.edu.ar/v1/images/8R.png","count":3}]},{"key":"stopover","values":[{"id":0,"count":3}]},{"key":"price","min":329.84,"max":363.32}]
     */

    private MetaBean meta;
    private int page;
    private int page_size;
    private int total;
    private CurrencyBean currency;
    private List<FlightsBean> flights;
    private List<FiltersBean> filters;

    public MetaBean getMeta() {
        return meta;
    }

    public void setMeta(MetaBean meta) {
        this.meta = meta;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPage_size() {
        return page_size;
    }

    public void setPage_size(int page_size) {
        this.page_size = page_size;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public CurrencyBean getCurrency() {
        return currency;
    }

    public void setCurrency(CurrencyBean currency) {
        this.currency = currency;
    }

    public List<FlightsBean> getFlights() {
        return flights;
    }

    public void setFlights(List<FlightsBean> flights) {
        this.flights = flights;
    }

    public List<FiltersBean> getFilters() {
        return filters;
    }

    public void setFilters(List<FiltersBean> filters) {
        this.filters = filters;
    }

    public static class MetaBean {
        /**
         * uuid : d54eaedb-e0df-4629-9ebb-62a69d9197e1
         * time : 1203.467697ms
         */

        private String uuid;
        private String time;

        public String getUuid() {
            return uuid;
        }

        public void setUuid(String uuid) {
            this.uuid = uuid;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }
    }

    public static class CurrencyBean {
        /**
         * id : USD
         */

        private String id;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }
    }

    public static class FlightsBean implements Serializable,Parcelable {
        /**
         * price : {"adults":{"base_fare":278,"quantity":1},"children":null,"infants":null,"total":{"charges":11.12,"taxes":55.6,"fare":278,"total":344.72}}
         * outbound_routes : [{"segments":[{"arrival":{"date":"2017-12-25 07:09:00","airport":{"id":"TUC","description":"Aeropuerto Benjamin Matienzo, San Miguel de Tucuman, Argentina","time_zone":"-03:00","city":{"id":"TUC","name":"San Miguel de Tucuman, Tucuman","country":{"id":"AR","name":"Argentina"}}}},"departure":{"date":"2017-12-25 05:50:00","airport":{"id":"EZE","description":"Aeropuerto Ezeiza Ministro Pistarini, Buenos Aires, Argentina","time_zone":"-03:00","city":{"id":"BUE","name":"Buenos Aires, Ciudad de Buenos Aires","country":{"id":"AR","name":"Argentina"}}}},"id":94588,"number":8700,"cabin_type":"ECONOMY","airline":{"id":"8R","name":"SOL","rating":1.55},"duration":"01:19","stopovers":[]}],"duration":"01:19"}]
         */

        private PriceBean price;
        private List<OutboundRoutesBean> outbound_routes;

        protected FlightsBean(Parcel in) {
        }

        public static final Creator<FlightsBean> CREATOR = new Creator<FlightsBean>() {
            @Override
            public FlightsBean createFromParcel(Parcel in) {
                return new FlightsBean(in);
            }

            @Override
            public FlightsBean[] newArray(int size) {
                return new FlightsBean[size];
            }
        };

        public PriceBean getPrice() {
            return price;
        }

        public void setPrice(PriceBean price) {
            this.price = price;
        }

        public List<OutboundRoutesBean> getOutbound_routes() {
            return outbound_routes;
        }

        public void setOutbound_routes(List<OutboundRoutesBean> outbound_routes) {
            this.outbound_routes = outbound_routes;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
        }

        public static class PriceBean {
            /**
             * adults : {"base_fare":278,"quantity":1}
             * children : null
             * infants : null
             * total : {"charges":11.12,"taxes":55.6,"fare":278,"total":344.72}
             */

            private AdultsBean adults;
            private Object children;
            private Object infants;
            private TotalBean total;

            public AdultsBean getAdults() {
                return adults;
            }

            public void setAdults(AdultsBean adults) {
                this.adults = adults;
            }

            public Object getChildren() {
                return children;
            }

            public void setChildren(Object children) {
                this.children = children;
            }

            public Object getInfants() {
                return infants;
            }

            public void setInfants(Object infants) {
                this.infants = infants;
            }

            public TotalBean getTotal() {
                return total;
            }

            public void setTotal(TotalBean total) {
                this.total = total;
            }

            public static class AdultsBean {
                /**
                 * base_fare : 278.0
                 * quantity : 1
                 */

                private double base_fare;
                private int quantity;

                public double getBase_fare() {
                    return base_fare;
                }

                public void setBase_fare(double base_fare) {
                    this.base_fare = base_fare;
                }

                public int getQuantity() {
                    return quantity;
                }

                public void setQuantity(int quantity) {
                    this.quantity = quantity;
                }
            }

            public static class TotalBean {
                /**
                 * charges : 11.12
                 * taxes : 55.6
                 * fare : 278.0
                 * total : 344.72
                 */

                private double charges;
                private double taxes;
                private double fare;
                private double total;

                public double getCharges() {
                    return charges;
                }

                public void setCharges(double charges) {
                    this.charges = charges;
                }

                public double getTaxes() {
                    return taxes;
                }

                public void setTaxes(double taxes) {
                    this.taxes = taxes;
                }

                public double getFare() {
                    return fare;
                }

                public void setFare(double fare) {
                    this.fare = fare;
                }

                public double getTotal() {
                    return total;
                }

                public void setTotal(double total) {
                    this.total = total;
                }
            }
        }

        public static class OutboundRoutesBean {
            /**
             * segments : [{"arrival":{"date":"2017-12-25 07:09:00","airport":{"id":"TUC","description":"Aeropuerto Benjamin Matienzo, San Miguel de Tucuman, Argentina","time_zone":"-03:00","city":{"id":"TUC","name":"San Miguel de Tucuman, Tucuman","country":{"id":"AR","name":"Argentina"}}}},"departure":{"date":"2017-12-25 05:50:00","airport":{"id":"EZE","description":"Aeropuerto Ezeiza Ministro Pistarini, Buenos Aires, Argentina","time_zone":"-03:00","city":{"id":"BUE","name":"Buenos Aires, Ciudad de Buenos Aires","country":{"id":"AR","name":"Argentina"}}}},"id":94588,"number":8700,"cabin_type":"ECONOMY","airline":{"id":"8R","name":"SOL","rating":1.55},"duration":"01:19","stopovers":[]}]
             * duration : 01:19
             */

            private String duration;
            private List<SegmentsBean> segments;

            public String getDuration() {
                return duration;
            }

            public void setDuration(String duration) {
                this.duration = duration;
            }

            public List<SegmentsBean> getSegments() {
                return segments;
            }

            public void setSegments(List<SegmentsBean> segments) {
                this.segments = segments;
            }

            public static class SegmentsBean {
                /**
                 * arrival : {"date":"2017-12-25 07:09:00","airport":{"id":"TUC","description":"Aeropuerto Benjamin Matienzo, San Miguel de Tucuman, Argentina","time_zone":"-03:00","city":{"id":"TUC","name":"San Miguel de Tucuman, Tucuman","country":{"id":"AR","name":"Argentina"}}}}
                 * departure : {"date":"2017-12-25 05:50:00","airport":{"id":"EZE","description":"Aeropuerto Ezeiza Ministro Pistarini, Buenos Aires, Argentina","time_zone":"-03:00","city":{"id":"BUE","name":"Buenos Aires, Ciudad de Buenos Aires","country":{"id":"AR","name":"Argentina"}}}}
                 * id : 94588
                 * number : 8700
                 * cabin_type : ECONOMY
                 * airline : {"id":"8R","name":"SOL","rating":1.55}
                 * duration : 01:19
                 * stopovers : []
                 */

                private ArrivalBean arrival;
                private DepartureBean departure;
                private int id;
                private int number;
                private String cabin_type;
                private AirlineBean airline;
                private String duration;
                private List<?> stopovers;

                public ArrivalBean getArrival() {
                    return arrival;
                }

                public void setArrival(ArrivalBean arrival) {
                    this.arrival = arrival;
                }

                public DepartureBean getDeparture() {
                    return departure;
                }

                public void setDeparture(DepartureBean departure) {
                    this.departure = departure;
                }

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public int getNumber() {
                    return number;
                }

                public void setNumber(int number) {
                    this.number = number;
                }

                public String getCabin_type() {
                    return cabin_type;
                }

                public void setCabin_type(String cabin_type) {
                    this.cabin_type = cabin_type;
                }

                public AirlineBean getAirline() {
                    return airline;
                }

                public void setAirline(AirlineBean airline) {
                    this.airline = airline;
                }

                public String getDuration() {
                    return duration;
                }

                public void setDuration(String duration) {
                    this.duration = duration;
                }

                public List<?> getStopovers() {
                    return stopovers;
                }

                public void setStopovers(List<?> stopovers) {
                    this.stopovers = stopovers;
                }

                public static class ArrivalBean {
                    /**
                     * date : 2017-12-25 07:09:00
                     * airport : {"id":"TUC","description":"Aeropuerto Benjamin Matienzo, San Miguel de Tucuman, Argentina","time_zone":"-03:00","city":{"id":"TUC","name":"San Miguel de Tucuman, Tucuman","country":{"id":"AR","name":"Argentina"}}}
                     */

                    private String date;
                    private AirportBean airport;

                    public String getDate() {
                        return date;
                    }

                    public void setDate(String date) {
                        this.date = date;
                    }

                    public AirportBean getAirport() {
                        return airport;
                    }

                    public void setAirport(AirportBean airport) {
                        this.airport = airport;
                    }

                    public static class AirportBean {
                        /**
                         * id : TUC
                         * description : Aeropuerto Benjamin Matienzo, San Miguel de Tucuman, Argentina
                         * time_zone : -03:00
                         * city : {"id":"TUC","name":"San Miguel de Tucuman, Tucuman","country":{"id":"AR","name":"Argentina"}}
                         */

                        private String id;
                        private String description;
                        private String time_zone;
                        private CityBean city;

                        public String getId() {
                            return id;
                        }

                        public void setId(String id) {
                            this.id = id;
                        }

                        public String getDescription() {
                            return description;
                        }

                        public void setDescription(String description) {
                            this.description = description;
                        }

                        public String getTime_zone() {
                            return time_zone;
                        }

                        public void setTime_zone(String time_zone) {
                            this.time_zone = time_zone;
                        }

                        public CityBean getCity() {
                            return city;
                        }

                        public void setCity(CityBean city) {
                            this.city = city;
                        }

                        public static class CityBean {
                            /**
                             * id : TUC
                             * name : San Miguel de Tucuman, Tucuman
                             * country : {"id":"AR","name":"Argentina"}
                             */

                            private String id;
                            private String name;
                            private CountryBean country;

                            public String getId() {
                                return id;
                            }

                            public void setId(String id) {
                                this.id = id;
                            }

                            public String getName() {
                                return name;
                            }

                            public void setName(String name) {
                                this.name = name;
                            }

                            public CountryBean getCountry() {
                                return country;
                            }

                            public void setCountry(CountryBean country) {
                                this.country = country;
                            }

                            public static class CountryBean {
                                /**
                                 * id : AR
                                 * name : Argentina
                                 */

                                private String id;
                                private String name;

                                public String getId() {
                                    return id;
                                }

                                public void setId(String id) {
                                    this.id = id;
                                }

                                public String getName() {
                                    return name;
                                }

                                public void setName(String name) {
                                    this.name = name;
                                }
                            }
                        }
                    }
                }

                public static class DepartureBean {
                    /**
                     * date : 2017-12-25 05:50:00
                     * airport : {"id":"EZE","description":"Aeropuerto Ezeiza Ministro Pistarini, Buenos Aires, Argentina","time_zone":"-03:00","city":{"id":"BUE","name":"Buenos Aires, Ciudad de Buenos Aires","country":{"id":"AR","name":"Argentina"}}}
                     */

                    private String date;
                    private AirportBeanX airport;

                    public String getDate() {
                        return date;
                    }

                    public void setDate(String date) {
                        this.date = date;
                    }

                    public AirportBeanX getAirport() {
                        return airport;
                    }

                    public void setAirport(AirportBeanX airport) {
                        this.airport = airport;
                    }

                    public static class AirportBeanX {
                        /**
                         * id : EZE
                         * description : Aeropuerto Ezeiza Ministro Pistarini, Buenos Aires, Argentina
                         * time_zone : -03:00
                         * city : {"id":"BUE","name":"Buenos Aires, Ciudad de Buenos Aires","country":{"id":"AR","name":"Argentina"}}
                         */

                        private String id;
                        private String description;
                        private String time_zone;
                        private CityBeanX city;

                        public String getId() {
                            return id;
                        }

                        public void setId(String id) {
                            this.id = id;
                        }

                        public String getDescription() {
                            return description;
                        }

                        public void setDescription(String description) {
                            this.description = description;
                        }

                        public String getTime_zone() {
                            return time_zone;
                        }

                        public void setTime_zone(String time_zone) {
                            this.time_zone = time_zone;
                        }

                        public CityBeanX getCity() {
                            return city;
                        }

                        public void setCity(CityBeanX city) {
                            this.city = city;
                        }

                        public static class CityBeanX {
                            /**
                             * id : BUE
                             * name : Buenos Aires, Ciudad de Buenos Aires
                             * country : {"id":"AR","name":"Argentina"}
                             */

                            private String id;
                            private String name;
                            private CountryBeanX country;

                            public String getId() {
                                return id;
                            }

                            public void setId(String id) {
                                this.id = id;
                            }

                            public String getName() {
                                return name;
                            }

                            public void setName(String name) {
                                this.name = name;
                            }

                            public CountryBeanX getCountry() {
                                return country;
                            }

                            public void setCountry(CountryBeanX country) {
                                this.country = country;
                            }

                            public static class CountryBeanX {
                                /**
                                 * id : AR
                                 * name : Argentina
                                 */

                                private String id;
                                private String name;

                                public String getId() {
                                    return id;
                                }

                                public void setId(String id) {
                                    this.id = id;
                                }

                                public String getName() {
                                    return name;
                                }

                                public void setName(String name) {
                                    this.name = name;
                                }
                            }
                        }
                    }
                }

                public static class AirlineBean {
                    /**
                     * id : 8R
                     * name : SOL
                     * rating : 1.55
                     */

                    private String id;
                    private String name;
                    private double rating;

                    public String getId() {
                        return id;
                    }

                    public void setId(String id) {
                        this.id = id;
                    }

                    public String getName() {
                        return name;
                    }

                    public void setName(String name) {
                        this.name = name;
                    }

                    public double getRating() {
                        return rating;
                    }

                    public void setRating(double rating) {
                        this.rating = rating;
                    }
                }
            }
        }
    }

    public static class FiltersBean {
        /**
         * key : airline
         * values : [{"id":"8R","name":"SOL","logo":"http://hci.it.itba.edu.ar/v1/images/8R.png","count":3}]
         * min : 329.84
         * max : 363.32
         */

        private String key;
        private double min;
        private double max;
        private List<ValuesBean> values;

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public double getMin() {
            return min;
        }

        public void setMin(double min) {
            this.min = min;
        }

        public double getMax() {
            return max;
        }

        public void setMax(double max) {
            this.max = max;
        }

        public List<ValuesBean> getValues() {
            return values;
        }

        public void setValues(List<ValuesBean> values) {
            this.values = values;
        }

        public static class ValuesBean {
            /**
             * id : 8R
             * name : SOL
             * logo : http://hci.it.itba.edu.ar/v1/images/8R.png
             * count : 3
             */

            private String id;
            private String name;
            private String logo;
            private int count;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getLogo() {
                return logo;
            }

            public void setLogo(String logo) {
                this.logo = logo;
            }

            public int getCount() {
                return count;
            }

            public void setCount(int count) {
                this.count = count;
            }
        }
    }
}
