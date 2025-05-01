package advanced.lv6;

public enum DiscountType {
    //속성
    NATIONAL_MERITORIOUS_PERSON("국가유공자", 10),
    SOLDIER("군인", 5),
    STUDENT("학생", 3),
    GENERAL("일반", 0),
    ;


    private final String type;
    private final int discountPercent;

    //생성자
    DiscountType(String type, int discountPercent) {
        this.type = type;
        this.discountPercent = discountPercent;
    }

    public String getType() {
        return type;
    }

    public int getDiscountPercent() {
        return discountPercent;
    }

    public int discount(DiscountType discountType, int totalPrice) {
        return totalPrice * discountPercent / 100;
    }
}
