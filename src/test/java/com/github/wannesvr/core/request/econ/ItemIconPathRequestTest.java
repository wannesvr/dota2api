package com.github.wannesvr.core.request.econ;

import com.github.wannesvr.BaseTest;
import com.github.wannesvr.core.model.item.ItemIconType;
import com.github.wannesvr.testhelpers.UrlParamHelper;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ItemIconPathRequestTest extends BaseTest {
    @Test
    public void testGetItemIconPathRequest() {
        ItemIconPathRequest itemIconPathRequest = new ItemIconPathRequest
                .Builder("iconName")
                .iconType(ItemIconType.INGAME)
                .build();

        UrlParamHelper helper = new UrlParamHelper(itemIconPathRequest.getRequest());

        assertThat(helper.getParameterValueByKey("iconname"), is("iconName"));
        assertThat(helper.getParameterValueByKey("icontype"), is("2"));
    }
}