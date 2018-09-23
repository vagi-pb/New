package com.vpb.www.bmicalculator;

public class result {
        public static final String TABLE_NAME = "calorienbmi";

        public static final String COLUMN_ID = "id";
        public static final String COLUMN_BMI = "bmi";
        public static final String COLUMN_CALORIEBURN = "calorieburn";
        public static final String COLUMN_TIME = "time";

        private int id;
        private String bmi;
        private String calorieburn;
        private String time;


        public result() {
        }

        public result(int id, String note, String calorieburn, String time) {
            this.id = id;
            this.bmi = bmi;
            this.calorieburn = calorieburn;
            this.time = time;
        }

        public int getId() {
            return id;
        }

        public String getbmi() {
            return bmi;
        }

        public String getCalorieburn() {
            return calorieburn;
        }

        public void setbmi(String bmi) {
            this.bmi = bmi;
        }

        public void setCalorieburn(String calorieburn) {
            this.calorieburn = calorieburn;
        }

        public String getTime() {
            return time;
        }

        public void setId(int id) {
            this.id = id;
        }

        public void setTime(String time) {
            this.time = time;
        }
}
