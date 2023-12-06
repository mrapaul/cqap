package web;

import com.peirs.datamodel.*;
import com.vaadin.data.util.*;

public class UserContainer extends BeanContainer<String, User>
{
    public UserContainer() throws IllegalArgumentException
    {
        super(User.class);

        setBeanIdResolver(new BeanIdResolver<String, User>()
        {
            @Override public String getIdForBean(User bean)
            {
                return bean.getId();
            }
        });
    }

    @Override public BeanItem<User> addItemAt(int index)
    {
        User emptyUser = createEmptyUser();
        return super.addItemAt(index,
                emptyUser.getId(),
                emptyUser);
    }

    private User createEmptyUser()
    {
        User user = new User();
        user.setId("unassigned");
        user.setUsername("newuser");
        user.setName("New User");
        user.setOsirixConfiguration(new OsirixConfiguration("localhost", 11111, "LLDSTORE"));

        return user;
    }
}
