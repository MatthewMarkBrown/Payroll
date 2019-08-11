package ac.za.Payroll.model.demography;

import java.util.Objects;

public class Gender {
    private String genderId;
    private String genderName;

    private Gender(){}

    private Gender(Builder builder) {
        this.genderId = builder.genderId;
        this.genderName = builder.genderName;
    }

    public String getGenderId() {
        return genderId;
    }

    public String getGenderName() {
        return genderName;
    }

    public static class Builder{

        private String genderId, genderName;

        public Builder genderId(String genderId) {
            this.genderId = genderId;
            return this;
        }

        public Builder genderName(String genderName) {
            this.genderName = genderName;
            return this;
        }

        public Builder copy(Gender course){
            this.genderId = course.genderId;
            this.genderName = course.genderName;

            return this;
        }

        public Gender build() {
            return new Gender(this);
        }

    }

    @Override
    public String toString() {
        return "Gender{" +
                "genderId='" + genderId + '\'' +
                ", genderName='" + genderName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Gender gender = (Gender) o;
        return genderId.equals(gender.genderId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(genderId);
    }

}
