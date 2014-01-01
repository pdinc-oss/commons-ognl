package org.apache.commons.ognl.internal.entry;

/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

/*
 * $Id: FiedlCacheEntryFactory.java 1194954 2011-10-29 18:00:27Z mcucchiara $
 */

import org.apache.commons.ognl.OgnlCache;
import org.apache.commons.ognl.internal.CacheException;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class FieldCacheEntryFactory
    implements ClassCacheEntryFactory<Map<String, Field>>
{
    public Map<String, Field> create( Class<?> key )
        throws CacheException
    {
        Field[] declaredFields = key.getDeclaredFields();
        Map<String, Field> result = new HashMap<String, Field>( declaredFields.length );
        for ( Field field : declaredFields )
        {
            result.put( field.getName(), field );
        }
        return result;
    }
    private OgnlCache cache;

    @Override
    public void setOgnlCache(OgnlCache cache)
    {
        this.cache=cache;
    }
}

