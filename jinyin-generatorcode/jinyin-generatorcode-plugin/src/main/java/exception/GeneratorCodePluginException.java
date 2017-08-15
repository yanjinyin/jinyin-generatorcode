package exception;

/**
 * 
 * @Description: 自定义生成代码插件异常
 * @author yanjinyin
 * @date 2017年8月9日 下午10:50:26
 */
public class GeneratorCodePluginException extends RuntimeException {

	/** serialVersionUID */
	private static final long serialVersionUID = 2332608236621015980L;

	private String code;

	public GeneratorCodePluginException() {
		super();
	}

	public GeneratorCodePluginException(String message) {
		super(message);
	}

	public GeneratorCodePluginException(String code, String message) {
		super(message);
		this.code = code;
	}

	public GeneratorCodePluginException(Throwable cause) {
		super(cause);
	}

	public GeneratorCodePluginException(String message, Throwable cause) {
		super(message, cause);
	}

	public GeneratorCodePluginException(String code, String message, Throwable cause) {
		super(message, cause);
		this.code = code;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

}
