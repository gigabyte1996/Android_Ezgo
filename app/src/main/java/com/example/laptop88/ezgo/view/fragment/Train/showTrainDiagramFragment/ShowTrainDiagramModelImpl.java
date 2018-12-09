package com.example.laptop88.ezgo.view.fragment.Train.showTrainDiagramFragment;

import com.example.laptop88.ezgo.Utils.Constants;
import com.example.laptop88.ezgo.response.SeatStorage;
import com.example.laptop88.ezgo.response.SeatStorageDeleteRequest;
import com.example.laptop88.ezgo.response.SeatStorageResponse;
import com.example.laptop88.ezgo.service.ApplicationApi;
import com.example.laptop88.ezgo.service.SeatStorageApi;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ShowTrainDiagramModelImpl implements ShowTrainDiagramModel {
    private ShowTrainDiagramPresenter mShowTrainDiagramFragmentPresenter;
    private ApplicationApi mApplicationApi;

    public ShowTrainDiagramModelImpl(ShowTrainDiagramPresenter showTrainDiagramFragmentPresenter) {
        if (mApplicationApi == null){
            mApplicationApi = new ApplicationApi();
        }
        mShowTrainDiagramFragmentPresenter = showTrainDiagramFragmentPresenter;
    }

    @Override
    public void addSeatStorage(SeatStorage seatStorage) {
        Call<SeatStorageResponse> call = mApplicationApi.getClient().create(SeatStorageApi.class).addSeatStorage(seatStorage);
          call.enqueue(new Callback<SeatStorageResponse>() {
              @Override
              public void onResponse(Call<SeatStorageResponse> call, Response<SeatStorageResponse> response) {
                  SeatStorageResponse seatStorageResponse= response.body();
                  int code = Integer.parseInt(seatStorageResponse.getError().getCode());

                  switch (code) {
                      case Constants.HTTPCodeResponse.SUCCESS:
                          mShowTrainDiagramFragmentPresenter.addSeatStorageSuccess(seatStorageResponse);

                          break;
                      default:
                          mShowTrainDiagramFragmentPresenter.addSeatStorageFalse();
                          break;
                  }
              }

              @Override
              public void onFailure(Call<SeatStorageResponse> call, Throwable t) {
                  mShowTrainDiagramFragmentPresenter.addSeatStorageFalse();
              }
          });

    }

    @Override
    public void deleteSeatStorage(SeatStorageDeleteRequest seatStorageDeleteRequest) {
        Call<SeatStorageResponse> call = mApplicationApi.getClient().create(SeatStorageApi.class).deleteSeatStorage(seatStorageDeleteRequest);
        call.enqueue(new Callback<SeatStorageResponse>() {
            @Override
            public void onResponse(Call<SeatStorageResponse> call, Response<SeatStorageResponse> response) {
                SeatStorageResponse seatStorageResponse= response.body();
                int code = Integer.parseInt(seatStorageResponse.getError().getCode());

                switch (code) {
                    case Constants.HTTPCodeResponse.SUCCESS:
                        mShowTrainDiagramFragmentPresenter.deleteSeatStorageSuccess(seatStorageResponse);

                        break;
                    default:
                        mShowTrainDiagramFragmentPresenter.deleteSeatStorageFalse();
                        break;
                }
            }

            @Override
            public void onFailure(Call<SeatStorageResponse> call, Throwable t) {
                mShowTrainDiagramFragmentPresenter.deleteSeatStorageFalse();
            }
        });
    }
}
