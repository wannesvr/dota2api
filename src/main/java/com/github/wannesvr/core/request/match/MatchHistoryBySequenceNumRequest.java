package com.github.wannesvr.core.request.match;

import com.github.wannesvr.core.request.AbstractSteamApiRequest;
import com.github.wannesvr.core.request.SteamApiRequestBuilder;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

/**
 * Request to //IDOTA2Match_570/GetMatchHistoryBySequenceNum/v1.
 * Returns match history ordered by sequence number.
 */
@Setter(AccessLevel.PRIVATE)
@Getter
public class MatchHistoryBySequenceNumRequest extends AbstractSteamApiRequest {
    private long startAtMatchSequenceNumber;
    private int matchesRequested;

    public MatchHistoryBySequenceNumRequest() {
        super("/IDOTA2Match_570/GetMatchHistoryBySequenceNum/v1");
    }

    public static class Builder implements SteamApiRequestBuilder<MatchHistoryBySequenceNumRequest> {
        private MatchHistoryBySequenceNumRequest request;

        public Builder() {
            this.request = new MatchHistoryBySequenceNumRequest();
        }

        /**
         * The match sequence number to start returning results from.
         *
         * @param sequenceNumber The sequence number
         * @return Builder instance
         */
        public Builder startAtMatchSequenceNumber(long sequenceNumber) {
            this.request.urlParam("start_at_match_seq_num", sequenceNumber);
            this.request.setStartAtMatchSequenceNumber(sequenceNumber);
            return this;
        }

        /**
         * The match sequence number to start returning results from.
         *
         * @param matchesRequested The sequence number
         * @return Builder instance
         */
        public Builder matchesRequested(int matchesRequested) {
            this.request.urlParam("matches_requested", matchesRequested);
            this.request.setStartAtMatchSequenceNumber(matchesRequested);
            return this;
        }

        @Override
        public MatchHistoryBySequenceNumRequest build() {
            return request;
        }
    }
}
