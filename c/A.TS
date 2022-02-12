const body = {
  isUpdated: true,
  tradeId: true,
  checklist: true,
  newOrder: true,
  order: true,
  product: true,
};

const validacao1 = body.tradeId && body.checklist && body.order && body.product;
