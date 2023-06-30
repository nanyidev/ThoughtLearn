package cn.tw.base.exception;

public class ThoughtLearnException extends RuntimeException{
        private String errMessage;

    public ThoughtLearnException() {
        super();
    }

    public ThoughtLearnException(String errMessage) {
        super(errMessage);
        this.errMessage = errMessage;
    }

    public String getErrMessage() {
        return errMessage;
    }

    public static void cast(CommonError commonError){
        throw new ThoughtLearnException(commonError.getErrMessage());
    }
    public static void cast(String errMessage){
        throw new ThoughtLearnException(errMessage);
    }

}
