SELECT
  a.resourceId,
  r.last_name || ' ' || r.first_name AS resourceName,
  a.startDate,
  a.baseCost,
  a.exchangeRate,
  c.letter_code AS currency,
  a.changeType
FROM (
  SELECT
    rc.resource_id as resourceId,
    rc.start_date as startDate,
    rc.base_cost as baseCost,
    rc.currency_id,
    ex.exchange_rate as exchangeRate,
    0 as changeType
  FROM resource_cost rc
  LEFT JOIN exchange_currency_rates ex ON ex.currency_from=rc.currency_id AND date=(
    SELECT max(date) FROM exchange_currency_rates WHERE currency_from=rc.currency_id AND date<=rc.start_date
  )
  UNION ALL
  SELECT
    rc.resource_id as resourceId,
    ex.date AS startDate,
    rc.base_cost as baseCost,
    rc.currency_id,
    ex.exchange_rate as exchangeRate,
    1 as changeType
  FROM exchange_currency_rates ex
  JOIN resource_cost rc ON rc.currency_id = ex.currency_from AND rc.start_date = (
    SELECT max(start_date) FROM resource_cost WHERE start_date<=ex.date AND resource_id = rc.resource_id
  ) AND NOT rc.id=COALESCE((SELECT id FROM resource_cost WHERE resource_id=rc.resource_id AND start_date=ex.date AND currency_id=ex.currency_from), 0)
  WHERE rc.currency_id=ex.currency_from
) a
LEFT JOIN resource r ON r.id=a.resourceId
LEFT JOIN currency c ON c.id=a.currency_id
WHERE
  a.startDate BETWEEN '2015-01-01' AND '2015-09-03'
  AND a.resourceId IN (18436, 296520)
ORDER BY
  resourceName,
  a.startDate;