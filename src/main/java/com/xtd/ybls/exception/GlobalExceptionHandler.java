package com.xtd.ybls.exception;

import com.xtd.ybls.enums.CommonEnum;
import com.xtd.ybls.result.ResultBody;
import org.springframework.web.bind.annotation.ControllerAdvice;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.SQLException;

/**
 *
 * @author frn
 */
@ControllerAdvice
public class GlobalExceptionHandler {
	private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);
	
	/**
	 * 处理自定义的业务异常
	 */
    @ExceptionHandler(value = BizException.class)  
    @ResponseBody  
	public ResultBody bizExceptionHandler(BizException e){
    	logger.error("发生业务异常！原因是：{}",e.getErrorMsg());
    	return ResultBody.error(e.getErrorCode(),e.getErrorMsg());
    }
	/**
	 * 处理空指针的异常
	 */
	@ExceptionHandler(value =NullPointerException.class)
	@ResponseBody
	public ResultBody exceptionHandler(NullPointerException e){
		logger.error("发生空指针异常！原因是:",e);
		return ResultBody.error(CommonEnum.BODY_NOT_MATCH);
	}

	/**
	 * 处理算数不合法的异常
	 * @param e
	 * @return ResultBody
	 */
	@ExceptionHandler(value =ArithmeticException.class)
	@ResponseBody
	public ResultBody exceptionHandler(ArithmeticException e){
		logger.error("发生算数不合法异常！原因是:",e);
		return ResultBody.error(CommonEnum.ARITHMETIC_IS_ILLEGAL);
	}
	/**
	 * 数组索引越界的异常
	 * @param req
	 * @param e
	 * @return
	 */
	@ExceptionHandler(value =java.lang.ArrayIndexOutOfBoundsException.class)
	@ResponseBody
	public ResultBody exceptionHandler(HttpServletRequest req, java.lang.ArrayIndexOutOfBoundsException e){
		logger.error("发生数组索引越界异常！原因是:",e);
		return ResultBody.error(CommonEnum.ARRAY_INDEX_OUT_OF_BOUNDS_EXCEPTION);
	}
	/**
	 * 错误的sql参数异常
	 * @param req
	 * @param e
	 * @return
	 */
	@ExceptionHandler(value =org.springframework.jdbc.BadSqlGrammarException.class)
	@ResponseBody
	public ResultBody exceptionHandler(HttpServletRequest req, org.springframework.jdbc.BadSqlGrammarException e){
		logger.error("发生错误的sql参数异常！原因是:",e);
		return ResultBody.error(CommonEnum.BAD_SQL_GRAMMAR_EXCEPTION);
	}
	/**
	 * 主键冲突
	 * @param req
	 * @param e
	 * @return
	 */
	@ExceptionHandler(value =org.springframework.dao.DuplicateKeyException.class)
	@ResponseBody
	public ResultBody exceptionHandler(HttpServletRequest req, org.springframework.dao.DuplicateKeyException e){
		logger.error("主键冲突异常！原因是:",e);
		return ResultBody.error(CommonEnum.DUPLICATE_KEY_EXCEPTION);
	}
	/**
	 * 处理方法未找到的异常
	 * @param req
	 * @param e
	 * @return
	 */
	@ExceptionHandler(value =NoSuchMethodException.class)
	@ResponseBody
	public ResultBody exceptionHandler(HttpServletRequest req, NoSuchMethodException e){
		logger.error("方法未找到！原因是:",e);
		return ResultBody.error(CommonEnum.NOT_FOUND);
	}
	/**
	 * 处理操作数据库异常
	 * @param req
	 * @param e
	 * @return
	 */
	@ExceptionHandler(value =SQLException.class)
	@ResponseBody
	public ResultBody exceptionHandler(HttpServletRequest req, SQLException e){
		logger.error("操作数据库异常！原因是:",e);
		return ResultBody.error(CommonEnum.OPERATION_DATABASE_EXCEPTION);
	}
    /**
	 * 处理其他异常
     * @param req
     * @param e
     * @return
     */
    @ExceptionHandler(value =Exception.class)
	@ResponseBody
	public ResultBody exceptionHandler(HttpServletRequest req, Exception e){
    	logger.error("未知异常！原因是:",e);
       	return ResultBody.error(CommonEnum.INTERNAL_SERVER_ERROR);
    }
}