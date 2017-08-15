import { DemoAppClientPage } from './app.po';

describe('demo-app-client App', () => {
  let page: DemoAppClientPage;

  beforeEach(() => {
    page = new DemoAppClientPage();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});
