package web;

import com.vaadin.data.util.converter.*;

import java.util.*;

public class LongToDateConverter implements Converter<Long, Date>
{
    @Override public Date convertToModel(Long value,
                                         Class<? extends Date> targetType,
                                         Locale locale) throws ConversionException
    {
        return new Date(value);
    }

    @Override public Long convertToPresentation(Date value,
                                                Class<? extends Long> targetType,
                                                Locale locale) throws ConversionException
    {
        return value.getTime();
    }

    @Override public Class<Date> getModelType()
    {
        return Date.class;
    }

    @Override public Class<Long> getPresentationType()
    {
        return Long.class;
    }
}
