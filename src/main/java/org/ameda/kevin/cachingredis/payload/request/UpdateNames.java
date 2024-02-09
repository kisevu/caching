package org.ameda.kevin.cachingredis.payload.request;/*
*
@author ameda
@project caching-redis
@package org.ameda.kevin.cachingredis.payload.request
*
*/

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpdateNames {

    private String firstName;
    private String lastName;
}
