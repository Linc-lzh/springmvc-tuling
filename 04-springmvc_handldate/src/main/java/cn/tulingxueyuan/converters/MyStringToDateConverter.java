package cn.tulingxueyuan.converters;

import org.springframework.core.convert.ConversionFailedException;
import org.springframework.core.convert.converter.Converter;
import org.springframework.util.StringUtils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

/***
 * @Author 徐庶   QQ:1092002729
 * @Slogan 致敬大师，致敬未来的你
 *
 * 1.定义类型转换器   需要明确 源类型 和目标性
 * 2.在convert方法自定义类型转换的实现
 * 3.在springmvc中配置自定类型转换器
 *     <bean class="org.springframework.context.support.ConversionServiceFactoryBean" id="conversionService">
 *         <property name="converters">
 *             <set>
 *                 <bean class="cn.tulingxueyuan.converters.MyStringToDateConverter"></bean>
 *             </set>
 *         </property>
 *     </bean>
 * 4.<mvc:annotation-driven conversion-service="conversionService"></mvc:annotation-driven>
 */
public class MyStringToDateConverter implements Converter<String, Date> {
    @Override
    public Date convert(String source) {
        if(!StringUtils.isEmpty(source)){
            // 即支持yyyy-MM-dd  yyyy/MM/dd
            try {
                if(source.split("-").length==3){
                    DateFormat df=new SimpleDateFormat("yyyy-MM-dd");
                    return df.parse(source);
                }
                else if(source.split("/").length==3){
                    DateFormat df=new SimpleDateFormat("yyyy/MM/dd");
                    return df.parse(source);
                }
                else
                {
                    throw new RuntimeException("日期转换错误:"+source);
                }

            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
