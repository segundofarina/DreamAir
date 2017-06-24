package itba.dreamair2.httprequests;


import java.util.List;

/**
 * Created by segundofarina on 16/6/17.
 */

public class DealResponse {


    /**
     * meta : {"uuid":"95c7e9f3-5eb0-4806-9292-90a92ddb37d6","time":"44.892457ms"}
     * currency : {"id":"USD"}
     * deals : [{"city":{"id":"LON","name":"Londres, Inglaterra, Reino Unido","latitude":51.5027,"longitude":-0.1145,"country":{"id":"GB","name":"Reino Unido"}},"price":1350.36},{"city":{"id":"NQN","name":"Neuquen, Neuquen","latitude":-38.9493,"longitude":-68.0657,"country":{"id":"AR","name":"Argentina"}},"price":267.86},{"city":{"id":"NYC","name":"Nueva York, New York, Estados Unidos","latitude":40.7022,"longitude":-74.0183,"country":{"id":"US","name":"Estados Unidos"}},"price":1008.94},{"city":{"id":"RGL","name":"Rio Gallegos, Santa Cruz","latitude":-51.633,"longitude":-69.2276,"country":{"id":"AR","name":"Argentina"}},"price":635},{"city":{"id":"IGR","name":"Puerto Iguazu, Misiones","latitude":-25.6667,"longitude":-54.4499,"country":{"id":"AR","name":"Argentina"}},"price":322.4},{"city":{"id":"SLA","name":"Salta, Salta","latitude":-24.7829,"longitude":-65.4121,"country":{"id":"AR","name":"Argentina"}},"price":343.48},{"city":{"id":"PSS","name":"Posadas, Misiones","latitude":-27.3621,"longitude":-55.9008,"country":{"id":"AR","name":"Argentina"}},"price":212.5},{"city":{"id":"MVD","name":"Montevideo, Montevideo, Uruguay","latitude":-34.8941,"longitude":-56.0674,"country":{"id":"UY","name":"Uruguay"}},"price":30.68},{"city":{"id":"MEX","name":"Ciudad de Mexico, Mexico D.F., Mexico","latitude":19.427,"longitude":-99.1276,"country":{"id":"MX","name":"Mexico"}},"price":974.05},{"city":{"id":"BCN","name":"Barcelona, España","latitude":41.3879,"longitude":2.1699,"country":{"id":"ES","name":"España"}},"price":1366.4},{"city":{"id":"SAO","name":"San Pablo, Sao Paulo, Brasil","latitude":-23.6267,"longitude":-46.6553,"country":{"id":"BR","name":"Brasil"}},"price":177.5},{"city":{"id":"PAR","name":"Paris, Francia","latitude":48.8567,"longitude":2.3509,"country":{"id":"FR","name":"Francia"}},"price":1375.2},{"city":{"id":"FLN","name":"Florianopolis, Brasil","latitude":-27.597,"longitude":-48.5496,"country":{"id":"BR","name":"Brasil"}},"price":154.58},{"city":{"id":"BOG","name":"Bogota, Colombia","latitude":4.6098,"longitude":-74.082,"country":{"id":"CO","name":"Colombia"}},"price":586.85},{"city":{"id":"CUN","name":"Cancun, Mexico","latitude":21.1478,"longitude":-86.835,"country":{"id":"MX","name":"Mexico"}},"price":847},{"city":{"id":"BHI","name":"Bahia Blanca, Buenos Aires","latitude":-38.7117,"longitude":-62.2681,"country":{"id":"AR","name":"Argentina"}},"price":147.5},{"city":{"id":"LAX","name":"Los Angeles, California, Estados Unidos","latitude":34.0522,"longitude":-118.243,"country":{"id":"US","name":"Estados Unidos"}},"price":1321.32},{"city":{"id":"SCL","name":"Santiago de Chile, Santiago, Chile","latitude":-33.4254,"longitude":-70.5665,"country":{"id":"CL","name":"Chile"}},"price":135.6},{"city":{"id":"LIM","name":"Lima, Lima, Peru","latitude":-12.0931,"longitude":-77.0464,"country":{"id":"PE","name":"Peru"}},"price":475},{"city":{"id":"ASU","name":"Asuncion, Central, Paraguay","latitude":-25.2399,"longitude":-57.519,"country":{"id":"PY","name":"Paraguay"}},"price":135.7},{"city":{"id":"MIA","name":"Miami, Florida, Estados Unidos","latitude":25.7743,"longitude":-80.1902,"country":{"id":"US","name":"Estados Unidos"}},"price":1026.08},{"city":{"id":"FTE","name":"El Calafate, Santa Cruz","latitude":-50.3402,"longitude":-72.2704,"country":{"id":"AR","name":"Argentina"}},"price":562.86},{"city":{"id":"CRD","name":"Comodoro Rivadavia, Chubut","latitude":-45.8679,"longitude":-67.5,"country":{"id":"AR","name":"Argentina"}},"price":446.4},{"city":{"id":"RIO","name":"Rio de Janeiro, Rio de Janeiro, Brasil","latitude":-22.9052,"longitude":-43.2147,"country":{"id":"BR","name":"Brasil"}},"price":248},{"city":{"id":"COR","name":"Cordoba, Cordoba","latitude":-31.3989,"longitude":-64.182,"country":{"id":"AR","name":"Argentina"}},"price":162.5},{"city":{"id":"REL","name":"Trelew, Chubut","latitude":-43.2491,"longitude":-65.3074,"country":{"id":"AR","name":"Argentina"}},"price":286.74},{"city":{"id":"MDZ","name":"Mendoza, Mendoza","latitude":-32.8902,"longitude":-68.844,"country":{"id":"AR","name":"Argentina"}},"price":238.08},{"city":{"id":"UAQ","name":"San Juan, San Juan","latitude":-31.5273,"longitude":-68.5213,"country":{"id":"AR","name":"Argentina"}},"price":247.5},{"city":{"id":"BRC","name":"San Carlos de Bariloche, Rio Negro","latitude":-41.1493,"longitude":-71.3012,"country":{"id":"AR","name":"Argentina"}},"price":346.92},{"city":{"id":"USH","name":"Ushuaia, Tierra del Fuego","latitude":-54.7917,"longitude":-68.2291,"country":{"id":"AR","name":"Argentina"}},"price":737.8}]
     */

    private MetaBean meta;
    private CurrencyBean currency;
    private List<DealsBean> deals;

    public MetaBean getMeta() {
        return meta;
    }

    public void setMeta(MetaBean meta) {
        this.meta = meta;
    }

    public CurrencyBean getCurrency() {
        return currency;
    }

    public void setCurrency(CurrencyBean currency) {
        this.currency = currency;
    }

    public List<DealsBean> getDeals() {
        return deals;
    }

    public void setDeals(List<DealsBean> deals) {
        this.deals = deals;
    }

    public static class MetaBean {
        /**
         * uuid : 95c7e9f3-5eb0-4806-9292-90a92ddb37d6
         * time : 44.892457ms
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

    public static class DealsBean {
        /**
         * city : {"id":"LON","name":"Londres, Inglaterra, Reino Unido","latitude":51.5027,"longitude":-0.1145,"country":{"id":"GB","name":"Reino Unido"}}
         * price : 1350.36
         */

        private CityBean city;
        private double price;

        public CityBean getCity() {
            return city;
        }

        public void setCity(CityBean city) {
            this.city = city;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public static class CityBean {
            /**
             * id : LON
             * name : Londres, Inglaterra, Reino Unido
             * latitude : 51.5027
             * longitude : -0.1145
             * country : {"id":"GB","name":"Reino Unido"}
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
                 * id : GB
                 * name : Reino Unido
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
