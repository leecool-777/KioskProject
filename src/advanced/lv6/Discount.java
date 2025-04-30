package advanced.lv6;

public enum Discount {
    //속성
    NATIONAL_MERITORIOUS_PERSON("국가유공자", 0.1),
    SOLDIER("군인", 0.05),
    STUDENT("학생", 0.03);

    private String type;
    private double discountRate;

    //생성자
    Discount(String type, double discountRate) {
        this.type = type;
        this.discountRate = discountRate;
    }
}
