import { DashboardClientPage } from './app.po';

describe('dashboard-client App', () => {
  let page: DashboardClientPage;

  beforeEach(() => {
    page = new DashboardClientPage();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});
