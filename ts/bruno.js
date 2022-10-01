const formatDate = (date) =>
  `${date.getFullYear()}-${formatNumber(date.getMonth() + 1)}-${formatNumber(
    date.getDate()
  )}T${formatNumber(date.getHours())}:${formatNumber(
    date.getMinutes()
  )}:${formatNumber(date.getSeconds())}-03:00`;
const formatNumber = (number) => `${('0' + number).slice(-2)}`;

const formatDate2 = (date) => `${date.toISOString().replace(/Z/, '')}-03:00`;
