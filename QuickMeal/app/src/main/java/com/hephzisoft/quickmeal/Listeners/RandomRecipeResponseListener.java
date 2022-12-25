package com.hephzisoft.quickmeal.Listeners;

import com.hephzisoft.quickmeal.Models.RandomRecipeAPIResponse;

public interface RandomRecipeResponseListener {
    void didFetch(RandomRecipeAPIResponse response, String message);
    void didError(String message);
}
