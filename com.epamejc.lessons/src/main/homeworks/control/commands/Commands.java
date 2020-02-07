package homeworks.control.commands;

public enum Commands {
    TRAFFICLIGHT {
        @Override
        public String getDescription(){
            String description = " push time in minutes(double) and get TrafficSignal";
            return super.getDescription()+ description;
        }
    }, EVENODDSTR{
        @Override
        public String getDescription(){
            String description = " push to integers with strategy even/odd and get result";
            return super.getDescription() + description;
        }
    }, PYRAMID{
        @Override
        public String getDescription(){
            String description = " push one integer and get your Pyramid";
            return super.getDescription() + description;
        }
    }, RANDOMCHAR{
        @Override
        public String getDescription(){
            String description = " push two integers and get your matrix";
            return super.getDescription() + description;
        }
    }, COUNTNUMS{
        @Override
        public String getDescription(){
            String description = " push two integers and get your matrix";
            return super.getDescription() + description;
        }
    }, POW {
        @Override
        public String getDescription() {
            String description = " push one int(num) and one int(pow) and i  will raise to a degree";
            return super.getDescription() + description;
        }
    }, FIBONACCI{
        @Override
        public String getDescription() {
            String description = " push one int i will return a fibonacci number";
            return super.getDescription() + description;
        }
    }, EVENODD{
        @Override
        public String getDescription() {
            String description = " push a string and a strategy even or odd and get your result";
            return super.getDescription() + description;
        }
    }, MAKEWORD{
        @Override
        public String getDescription() {
            String description = " push a string and amount of integers(indexes) and i will make new string";
            return super.getDescription() + description;
        }
    }
    , REWERSEWORD{
        @Override
        public String getDescription() {
            String description = " push a string and i will reverse only words";
            return super.getDescription() + description;
        }
    }, SWITHCHAR{
        @Override
        public String getDescription() {
            String description = " push a string and two int's indexes and i will switch chars";
            return super.getDescription() + description;
        }
    };

    @Override
    public String toString() {
        return name().toLowerCase();
    }
    public String getDescription(){
        StringBuilder sb = new StringBuilder();
        sb.append("/");
        sb.append(name().toLowerCase());
        sb.append(" Description:");
        return sb.toString();
    }
}
