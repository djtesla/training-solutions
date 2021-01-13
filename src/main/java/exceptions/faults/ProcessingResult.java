package exceptions.faults;

public enum ProcessingResult {

    WORD_COUNT_ERROR(2), VALUE_ERROR(4), DATE_ERROR(8), VALUE_AND_DATE_ERROR(12), COMMENT_LINE(-1), NO_ERROR(0);

    private int code;

    ProcessingResult(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
