import React from 'react';
import { shallow } from 'enzyme';
import Comedy from './Comedy';

describe('<Comedy />', () => {
  let component;

  beforeEach(() => {
    component = shallow(<Comedy />);
  });

  test('It should mount', () => {
    expect(component.length).toBe(1);
  });
});
