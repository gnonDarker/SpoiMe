package com.example.spoilme.exception;
import lombok.Data;

/**

 * Description:业务异常类信息

 * User: zhouzhou

 * Date: 2019-05-08

 * Time: 13:35

 */

@Data
public class ServiceException extends RuntimeException {

    private static final long serialVersionUID = -7864604160297181941L;

    /** 错误码 */

    private String code;

    /**

     * 无参默认构造UNSPECIFIED

     */

    public ServiceException() {
        super();
    }



    /**

     * 指定导火索构造通用异常

     * @param t 导火索

     */

    public ServiceException(final Throwable t) {
        super(t);
    }

    /**

     * 构造通用异常

     * @param code 错误码

     * @param detailedMessage 详细描述

     */

    public ServiceException(final String code, final String detailedMessage) {

        super(detailedMessage);

        this.code = code;

    }


}

