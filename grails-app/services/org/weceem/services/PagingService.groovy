package org.weceem.services

/**
 * PagingService.
 *
 * @author Sergei Shushkevich
 */
class PagingService {

    def maxResults = 10

    /**
     * Search items according to specified parameters.
     *
     * @param clazz        Domain class
     * @param params       Map of search parameters (e.g. offset, sort, etc.)
     * @param restrictions Closure with criteria restrictions
     *
     * @return   Map of search result, which contains
     *            "totalCount" - total count of found items;
     *            "items" - collection of found items.
     */
    def search(clazz, params, restrictions) {
        params.offset = params.offset ? Integer.valueOf(params.offset) : 0;
        params.max = params.max ? Integer.valueOf(params.max) : maxResults;

        def countCriteria = clazz.createCriteria()
        def totalCount = countCriteria.get {
            restrictions(countCriteria)
            projections { rowCount() }
        }

        def itemsCriteria = clazz.createCriteria()
        def items = itemsCriteria.list {
            restrictions(itemsCriteria)
            firstResult(params.offset)
            maxResults(params.max)
            if (params.sort) {
              order(params.sort, params.order)
            }
        }

        [totalCount: totalCount, items: items]
    }
}
