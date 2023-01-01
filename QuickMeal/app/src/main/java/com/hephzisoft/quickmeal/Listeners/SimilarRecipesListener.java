package com.hephzisoft.quickmeal.Listeners;

import com.hephzisoft.quickmeal.Models.SimilarRecipeResponse;

import java.util.List;

public interface SimilarRecipesListener {
    void didFetch(List<SimilarRecipeResponse> response, String message);
    void didError(String message);
}
