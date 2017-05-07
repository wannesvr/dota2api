package com.github.wannesvr.core.request.econ;

import com.github.wannesvr.core.request.AbstractSteamApiRequest;
import com.github.wannesvr.core.request.SteamApiRequestBuilder;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

/**
 * Request to /IEconDOTA2_570/GetHeroes/v1
 * Returns a list of heroes within Dota 2.
 *
 * @see com.github.wannesvr.core.model.hero.HeroList
 */
@Setter(AccessLevel.PRIVATE)
@Getter
public class HeroesRequest extends AbstractSteamApiRequest {
    private String language;
    private boolean itemizedOnly;

    private HeroesRequest() {
        super("/IEconDOTA2_570/GetHeroes/v1");
    }

    /**
     * Static builder class to be used to create an instance of {@link HeroesRequest}.
     */
    public static class Builder implements SteamApiRequestBuilder<HeroesRequest> {
        private HeroesRequest request;

        public Builder() {
            this.request = new HeroesRequest();
        }


        /**
         * The language to provide hero names in.
         *
         * @param language the language
         * @return Builder instance
         */
        public Builder language(String language) {
            this.request.urlParam("language", language);
            this.request.setLanguage(language);
            return this;
        }

        /**
         * If true, return a list of itemized heroes only.
         *
         * @param itemizedOnly whether you want itemized heroes only
         * @return Builder instance
         */
        public Builder itemizedOnly(boolean itemizedOnly) {
            this.request.urlParam("itemizedonly", itemizedOnly);
            this.request.setItemizedOnly(itemizedOnly);
            return this;
        }

        /**
         * Returns the {@code HeroesRequest} instance created by the builder.
         *
         * @return a {@link HeroesRequest}
         */
        @Override
        public HeroesRequest build() {
            return request;
        }
    }
}
