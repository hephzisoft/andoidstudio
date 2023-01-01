package com.hephzisoft.quickmeal.Listeners;

import com.hephzisoft.quickmeal.Models.RecipeDetailsResponse;

public interface RecipeDetailsListener {
    void didFetch(RecipeDetailsResponse response, String message);
    void didError(String message);
}
