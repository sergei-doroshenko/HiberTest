SELECT
  a.resource_id,
  last_name || ' ' || first_name AS name,
  a.start_date,
  /* a.base_cost, */
  a.currency_id,
  a.exchange_rate,
  rc.letter_code AS currency_name
FROM (
  SELECT
    rc.id,
    rc.resource_id,
    rc.start_date,
    rc.base_cost,
    rc.currency_id,
    ex.exchange_rate
  FROM resource_cost rc
  LEFT JOIN exchange_currency_rates ex ON ex.currency_from=rc.currency_id AND date=(
    SELECT max(date) FROM exchange_currency_rates WHERE currency_from=rc.currency_id AND date<=rc.start_date
  )

  UNION ALL
  SELECT
    rc.id,
    rc.resource_id,
    rc.start_date,
    rc.base_cost,
    rc.currency_id,
    ex.exchange_rate
  FROM exchange_currency_rates ex
  JOIN resource_cost rc ON rc.currency_id = ex.currency_from AND rc.start_date = (
    SELECT max(start_date) FROM resource_cost WHERE currency_id=ex.currency_from AND start_date<=ex.date
  ) AND NOT rc.id=COALESCE((SELECT id FROM resource_cost WHERE resource_id=rc.resource_id AND start_date=ex.date), 0)
) a
LEFT JOIN resource r ON r.id=a.resource_id
LEFT JOIN currency rc ON rc.id=a.currency_id
WHERE
  a.start_date BETWEEN '2015-01-01' AND '2015-06-01'
ORDER BY
  name,
  a.start_date;