package itba.dreamair2.httprequests;

/**
 * Created by segundofarina on 25/6/17.
 */

public class StatusResponse {


    /**
     * meta : {"uuid":"883ddea1-6538-4c8d-ae83-1cb8ad73ca9c","time":"28.722459ms"}
     * status : {"id":94588,"number":8700,"airline":{"id":"8R","name":"SOL","logo":"http://hci.it.itba.edu.ar/v1/images/8R.png"},"status":"L","departure":{"airport":{"id":"EZE","description":"Aeropuerto Ezeiza Ministro Pistarini, Buenos Aires, Argentina","time_zone":"-03:00","latitude":-34.8126,"longitude":-58.5397,"city":{"id":"BUE","name":"Buenos Aires, Ciudad de Buenos Aires","latitude":-34.8126,"longitude":-58.5397,"country":{"id":"AR","name":"Argentina"}},"terminal":"I","gate":"11"},"scheduled_time":"2017-06-25 05:50:00","actual_time":"2017-06-25 05:50:00","scheduled_gate_time":"2017-06-25 05:00:00","actual_gate_time":"2017-06-25 05:00:00","gate_delay":null,"estimate_runway_time":"2017-06-25 05:30:00","actual_runway_time":"2017-06-25 05:30:00","runway_delay":null},"arrival":{"airport":{"id":"TUC","description":"Aeropuerto Benjamin Matienzo, San Miguel de Tucuman, Argentina","time_zone":"-03:00","latitude":-26.8357,"longitude":-65.1083,"city":{"id":"TUC","name":"San Miguel de Tucuman, Tucuman","latitude":-26.8083,"longitude":-65.2176,"country":{"id":"AR","name":"Argentina"}},"terminal":"A","gate":"35","baggage":"1"},"scheduled_time":"2017-06-25 07:09:00","actual_time":"2017-06-25 07:21:00","scheduled_gate_time":"2017-06-25 07:59:00","actual_gate_time":"2017-06-25 08:11:00","gate_delay":null,"estimate_runway_time":"2017-06-25 07:29:00","actual_runway_time":"2017-06-25 07:41:00","runway_delay":null}}
     */

    private MetaBean meta;
    private StatusBean status;

    public MetaBean getMeta() {
        return meta;
    }

    public void setMeta(MetaBean meta) {
        this.meta = meta;
    }

    public StatusBean getStatus() {
        return status;
    }

    public void setStatus(StatusBean status) {
        this.status = status;
    }

    public static class MetaBean {
        /**
         * uuid : 883ddea1-6538-4c8d-ae83-1cb8ad73ca9c
         * time : 28.722459ms
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

    public static class StatusBean {
        /**
         * id : 94588
         * number : 8700
         * airline : {"id":"8R","name":"SOL","logo":"http://hci.it.itba.edu.ar/v1/images/8R.png"}
         * status : L
         * departure : {"airport":{"id":"EZE","description":"Aeropuerto Ezeiza Ministro Pistarini, Buenos Aires, Argentina","time_zone":"-03:00","latitude":-34.8126,"longitude":-58.5397,"city":{"id":"BUE","name":"Buenos Aires, Ciudad de Buenos Aires","latitude":-34.8126,"longitude":-58.5397,"country":{"id":"AR","name":"Argentina"}},"terminal":"I","gate":"11"},"scheduled_time":"2017-06-25 05:50:00","actual_time":"2017-06-25 05:50:00","scheduled_gate_time":"2017-06-25 05:00:00","actual_gate_time":"2017-06-25 05:00:00","gate_delay":null,"estimate_runway_time":"2017-06-25 05:30:00","actual_runway_time":"2017-06-25 05:30:00","runway_delay":null}
         * arrival : {"airport":{"id":"TUC","description":"Aeropuerto Benjamin Matienzo, San Miguel de Tucuman, Argentina","time_zone":"-03:00","latitude":-26.8357,"longitude":-65.1083,"city":{"id":"TUC","name":"San Miguel de Tucuman, Tucuman","latitude":-26.8083,"longitude":-65.2176,"country":{"id":"AR","name":"Argentina"}},"terminal":"A","gate":"35","baggage":"1"},"scheduled_time":"2017-06-25 07:09:00","actual_time":"2017-06-25 07:21:00","scheduled_gate_time":"2017-06-25 07:59:00","actual_gate_time":"2017-06-25 08:11:00","gate_delay":null,"estimate_runway_time":"2017-06-25 07:29:00","actual_runway_time":"2017-06-25 07:41:00","runway_delay":null}
         */

        private int id;
        private int number;
        private AirlineBean airline;
        private String status;
        private DepartureBean departure;
        private ArrivalBean arrival;

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

        public AirlineBean getAirline() {
            return airline;
        }

        public void setAirline(AirlineBean airline) {
            this.airline = airline;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public DepartureBean getDeparture() {
            return departure;
        }

        public void setDeparture(DepartureBean departure) {
            this.departure = departure;
        }

        public ArrivalBean getArrival() {
            return arrival;
        }

        public void setArrival(ArrivalBean arrival) {
            this.arrival = arrival;
        }

        public static class AirlineBean {
            /**
             * id : 8R
             * name : SOL
             * logo : http://hci.it.itba.edu.ar/v1/images/8R.png
             */

            private String id;
            private String name;
            private String logo;

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
        }

        public static class DepartureBean {
            /**
             * airport : {"id":"EZE","description":"Aeropuerto Ezeiza Ministro Pistarini, Buenos Aires, Argentina","time_zone":"-03:00","latitude":-34.8126,"longitude":-58.5397,"city":{"id":"BUE","name":"Buenos Aires, Ciudad de Buenos Aires","latitude":-34.8126,"longitude":-58.5397,"country":{"id":"AR","name":"Argentina"}},"terminal":"I","gate":"11"}
             * scheduled_time : 2017-06-25 05:50:00
             * actual_time : 2017-06-25 05:50:00
             * scheduled_gate_time : 2017-06-25 05:00:00
             * actual_gate_time : 2017-06-25 05:00:00
             * gate_delay : null
             * estimate_runway_time : 2017-06-25 05:30:00
             * actual_runway_time : 2017-06-25 05:30:00
             * runway_delay : null
             */

            private AirportBean airport;
            private String scheduled_time;
            private String actual_time;
            private String scheduled_gate_time;
            private String actual_gate_time;
            private Object gate_delay;
            private String estimate_runway_time;
            private String actual_runway_time;
            private Object runway_delay;

            public AirportBean getAirport() {
                return airport;
            }

            public void setAirport(AirportBean airport) {
                this.airport = airport;
            }

            public String getScheduled_time() {
                return scheduled_time;
            }

            public void setScheduled_time(String scheduled_time) {
                this.scheduled_time = scheduled_time;
            }

            public String getActual_time() {
                return actual_time;
            }

            public void setActual_time(String actual_time) {
                this.actual_time = actual_time;
            }

            public String getScheduled_gate_time() {
                return scheduled_gate_time;
            }

            public void setScheduled_gate_time(String scheduled_gate_time) {
                this.scheduled_gate_time = scheduled_gate_time;
            }

            public String getActual_gate_time() {
                return actual_gate_time;
            }

            public void setActual_gate_time(String actual_gate_time) {
                this.actual_gate_time = actual_gate_time;
            }

            public Object getGate_delay() {
                return gate_delay;
            }

            public void setGate_delay(Object gate_delay) {
                this.gate_delay = gate_delay;
            }

            public String getEstimate_runway_time() {
                return estimate_runway_time;
            }

            public void setEstimate_runway_time(String estimate_runway_time) {
                this.estimate_runway_time = estimate_runway_time;
            }

            public String getActual_runway_time() {
                return actual_runway_time;
            }

            public void setActual_runway_time(String actual_runway_time) {
                this.actual_runway_time = actual_runway_time;
            }

            public Object getRunway_delay() {
                return runway_delay;
            }

            public void setRunway_delay(Object runway_delay) {
                this.runway_delay = runway_delay;
            }

            public static class AirportBean {
                /**
                 * id : EZE
                 * description : Aeropuerto Ezeiza Ministro Pistarini, Buenos Aires, Argentina
                 * time_zone : -03:00
                 * latitude : -34.8126
                 * longitude : -58.5397
                 * city : {"id":"BUE","name":"Buenos Aires, Ciudad de Buenos Aires","latitude":-34.8126,"longitude":-58.5397,"country":{"id":"AR","name":"Argentina"}}
                 * terminal : I
                 * gate : 11
                 */

                private String id;
                private String description;
                private String time_zone;
                private double latitude;
                private double longitude;
                private CityBean city;
                private String terminal;
                private String gate;

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

                public double getLatitude() {
                    return latitude;
                }

                public void setLatitude(double latitude) {
                    this.latitude = latitude;
                }

                public double getLongitude() {
                    return longitude;
                }

                public void setLongitude(double longitude) {
                    this.longitude = longitude;
                }

                public CityBean getCity() {
                    return city;
                }

                public void setCity(CityBean city) {
                    this.city = city;
                }

                public String getTerminal() {
                    return terminal;
                }

                public void setTerminal(String terminal) {
                    this.terminal = terminal;
                }

                public String getGate() {
                    return gate;
                }

                public void setGate(String gate) {
                    this.gate = gate;
                }

                public static class CityBean {
                    /**
                     * id : BUE
                     * name : Buenos Aires, Ciudad de Buenos Aires
                     * latitude : -34.8126
                     * longitude : -58.5397
                     * country : {"id":"AR","name":"Argentina"}
                     */

                    private String id;
                    private String name;
                    private double latitude;
                    private double longitude;
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

                    public double getLatitude() {
                        return latitude;
                    }

                    public void setLatitude(double latitude) {
                        this.latitude = latitude;
                    }

                    public double getLongitude() {
                        return longitude;
                    }

                    public void setLongitude(double longitude) {
                        this.longitude = longitude;
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

        public static class ArrivalBean {
            /**
             * airport : {"id":"TUC","description":"Aeropuerto Benjamin Matienzo, San Miguel de Tucuman, Argentina","time_zone":"-03:00","latitude":-26.8357,"longitude":-65.1083,"city":{"id":"TUC","name":"San Miguel de Tucuman, Tucuman","latitude":-26.8083,"longitude":-65.2176,"country":{"id":"AR","name":"Argentina"}},"terminal":"A","gate":"35","baggage":"1"}
             * scheduled_time : 2017-06-25 07:09:00
             * actual_time : 2017-06-25 07:21:00
             * scheduled_gate_time : 2017-06-25 07:59:00
             * actual_gate_time : 2017-06-25 08:11:00
             * gate_delay : null
             * estimate_runway_time : 2017-06-25 07:29:00
             * actual_runway_time : 2017-06-25 07:41:00
             * runway_delay : null
             */

            private AirportBeanX airport;
            private String scheduled_time;
            private String actual_time;
            private String scheduled_gate_time;
            private String actual_gate_time;
            private Object gate_delay;
            private String estimate_runway_time;
            private String actual_runway_time;
            private Object runway_delay;

            public AirportBeanX getAirport() {
                return airport;
            }

            public void setAirport(AirportBeanX airport) {
                this.airport = airport;
            }

            public String getScheduled_time() {
                return scheduled_time;
            }

            public void setScheduled_time(String scheduled_time) {
                this.scheduled_time = scheduled_time;
            }

            public String getActual_time() {
                return actual_time;
            }

            public void setActual_time(String actual_time) {
                this.actual_time = actual_time;
            }

            public String getScheduled_gate_time() {
                return scheduled_gate_time;
            }

            public void setScheduled_gate_time(String scheduled_gate_time) {
                this.scheduled_gate_time = scheduled_gate_time;
            }

            public String getActual_gate_time() {
                return actual_gate_time;
            }

            public void setActual_gate_time(String actual_gate_time) {
                this.actual_gate_time = actual_gate_time;
            }

            public Object getGate_delay() {
                return gate_delay;
            }

            public void setGate_delay(Object gate_delay) {
                this.gate_delay = gate_delay;
            }

            public String getEstimate_runway_time() {
                return estimate_runway_time;
            }

            public void setEstimate_runway_time(String estimate_runway_time) {
                this.estimate_runway_time = estimate_runway_time;
            }

            public String getActual_runway_time() {
                return actual_runway_time;
            }

            public void setActual_runway_time(String actual_runway_time) {
                this.actual_runway_time = actual_runway_time;
            }

            public Object getRunway_delay() {
                return runway_delay;
            }

            public void setRunway_delay(Object runway_delay) {
                this.runway_delay = runway_delay;
            }

            public static class AirportBeanX {
                /**
                 * id : TUC
                 * description : Aeropuerto Benjamin Matienzo, San Miguel de Tucuman, Argentina
                 * time_zone : -03:00
                 * latitude : -26.8357
                 * longitude : -65.1083
                 * city : {"id":"TUC","name":"San Miguel de Tucuman, Tucuman","latitude":-26.8083,"longitude":-65.2176,"country":{"id":"AR","name":"Argentina"}}
                 * terminal : A
                 * gate : 35
                 * baggage : 1
                 */

                private String id;
                private String description;
                private String time_zone;
                private double latitude;
                private double longitude;
                private CityBeanX city;
                private String terminal;
                private String gate;
                private String baggage;

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

                public double getLatitude() {
                    return latitude;
                }

                public void setLatitude(double latitude) {
                    this.latitude = latitude;
                }

                public double getLongitude() {
                    return longitude;
                }

                public void setLongitude(double longitude) {
                    this.longitude = longitude;
                }

                public CityBeanX getCity() {
                    return city;
                }

                public void setCity(CityBeanX city) {
                    this.city = city;
                }

                public String getTerminal() {
                    return terminal;
                }

                public void setTerminal(String terminal) {
                    this.terminal = terminal;
                }

                public String getGate() {
                    return gate;
                }

                public void setGate(String gate) {
                    this.gate = gate;
                }

                public String getBaggage() {
                    return baggage;
                }

                public void setBaggage(String baggage) {
                    this.baggage = baggage;
                }

                public static class CityBeanX {
                    /**
                     * id : TUC
                     * name : San Miguel de Tucuman, Tucuman
                     * latitude : -26.8083
                     * longitude : -65.2176
                     * country : {"id":"AR","name":"Argentina"}
                     */

                    private String id;
                    private String name;
                    private double latitude;
                    private double longitude;
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

                    public double getLatitude() {
                        return latitude;
                    }

                    public void setLatitude(double latitude) {
                        this.latitude = latitude;
                    }

                    public double getLongitude() {
                        return longitude;
                    }

                    public void setLongitude(double longitude) {
                        this.longitude = longitude;
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
    }
}
