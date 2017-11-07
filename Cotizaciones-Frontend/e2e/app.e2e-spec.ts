import { CotizacionesFrontendPage } from './app.po';

describe('cotizaciones-frontend App', () => {
  let page: CotizacionesFrontendPage;

  beforeEach(() => {
    page = new CotizacionesFrontendPage();
  });

  it('should display welcome message', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('Welcome to app!!');
  });
});
