package priv.psq.designpatterns.converter;

import java.util.function.Function;

/**
 * BaseConverter.java
 * Description: 基础转换类
 *
 * @author Peng Shiquan
 * @date 2022/3/11
 */
public abstract class BaseConverter<T extends BaseVO, R extends BaseDTO> {

    private final Function<T, R> fromVO;

    public BaseConverter(Function<T, R> fromVO) {
        this.fromVO = fromVO;
    }

    /**
     * Description:
     *
     * @param vo 要转换的vo
     * @return T 返回的DTO
     * @author Peng Shiquan
     * @date 2022-03-11
     */
    public final R converterFromDto(final T vo) {
        return fromVO.apply(vo);
    }
}

